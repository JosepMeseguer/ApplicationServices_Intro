package com.example.softlearning.applicationcore.entity.client.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.softlearning.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning.applicationcore.entity.client.mappers.ClientMapper;
import com.example.softlearning.applicationcore.entity.client.persistence.ClientRepository;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class ClientServicesImpl implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;
    private Serializer<ClientDTO> serializer;

    
    // ****** Implementing the business logic methods and common featues (clean code design) ******

    protected ClientDTO getDTO(int id) throws ServiceException {

        return clientRepository.findById(id)
                               .orElseThrow (
                                    () -> new ServiceException("Client " + id + " not found")
                                );

    }

    protected ClientDTO checkInputData (String client) throws ServiceException {
        try {
            ClientDTO cdto = (ClientDTO)this.serializer.deserialize(client, ClientDTO.class);
            ClientMapper.clientFromDTO(cdto);
            return cdto;
        } catch (BuildException e) {
            throw new ServiceException("Error data in the input client :" + e.getMessage());
        }
    }

    protected ClientDTO newClient(String client) throws ServiceException{
        ClientDTO cdto = this.checkInputData(client);

        if ( this.getDTO(cdto.getCode()) != null) {
            throw new ServiceException("Client " + cdto.getCode() + " already exists");
        }
        return clientRepository.save(cdto);
    }

    protected ClientDTO updateClient(String client) throws ServiceException {
        
        ClientDTO cdto = this.checkInputData(client);
        
        if ( this.getDTO(cdto.getCode()) == null) {
            throw new ServiceException("Client " + cdto.getCode() + " not exists");
        }
        
        return clientRepository.save(cdto);
    }



    // ******  Implementing the interface methods   ******

    @Override
    public String getClientByIdToJson(int id) throws ServiceException{

        return SerializersCatalog.getInstance(Serializers.CLIENT_JSON)
                                 .serialize(this.getDTO(id));
        
    }

    @Override
    public String getClientByIdToXml(int id) throws ServiceException {

        return SerializersCatalog.getInstance(Serializers.CLIENT_XML)
                                 .serialize(this.getDTO(id));

    } 

    @Override
    public String newClientFromJson(String client) throws ServiceException {
        
        this.serializer = SerializersCatalog.getInstance(Serializers.CLIENT_JSON);
                
        return serializer.serialize(this.newClient(client));
    }


    @Override
    public String newClientFromXml(String client) throws ServiceException {
        
        this.serializer = SerializersCatalog.getInstance(Serializers.CLIENT_XML);

        return serializer.serialize(this.newClient(client));
    }

    @Override
    public String updateOneFromJson(String client) throws ServiceException {

        this.serializer = SerializersCatalog.getInstance(Serializers.CLIENT_JSON);

        return serializer.serialize(this.updateClient(client));
    }

    @Override
    public String updateOneFromXml(String client) throws ServiceException {

        this.serializer = SerializersCatalog.getInstance(Serializers.CLIENT_XML);

        return serializer.serialize(this.updateClient(client));

    }

    @Override
    public void deleteById(int id) throws ServiceException {
        if (this.getDTO(id) == null) {
            throw new ServiceException("Client not exists");
        }
        clientRepository.deleteById(id);
    }
}
