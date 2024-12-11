package com.example.softlearning.applicationcore.entity.client.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.softlearning.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning.applicationcore.entity.client.persistence.ClientRepository;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class getClientByIdController {

    @Autowired
    private ClientRepository clientRepository;
    private Serializer<ClientDTO> serializer;
    private ClientDTO cdto;

    public String getJson(int id) throws ServiceException{

        serializer = SerializersCatalog.getInstance(Serializers.CLIENT_JSON);
        
        cdto = this.getDTO(id);

        return serializer.serialize(cdto);
    }


    public String getXML(int id) throws ServiceException {
        serializer = SerializersCatalog.getInstance(Serializers.CLIENT_XML);

        cdto = this.getDTO(id);

        return serializer.serialize(cdto);
    } 


    public ClientDTO getDTO(int id) throws ServiceException {
        return clientRepository.findById(id).orElseThrow(() -> new ServiceException("Client not found"));
    }
}
