package com.example.softlearning.applicationcore.entity.client.mappers;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning.applicationcore.entity.client.model.Client;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ClientMapper {

    public static Client clientFromDTO(ClientDTO cdto) throws BuildException {       
        return Client.getInstance(cdto.getName(),
                                  cdto.getIdent(), 
                                  cdto.getBirthday(),
                                  cdto.getAddress(),
                                  cdto.getPhone(),
                                  cdto.getCreditcard(),
                                  cdto.getPassword(),
                                  cdto.getCode(),
                                  cdto.isPremium(),
                                  cdto.getSince()
        );
    }
    public static ClientDTO dtoFromClient(Client c) {
        return new ClientDTO(   c.getName(), 
                                c.getIdent(),
                                c.getBirthday(),
                                c.getAddress(),
                                c.getPhone(),
                                c.getCreditcard(),
                                c.getPassword(),
                                c.getCode(), 
                                c.getPremium(),
                                c.getSince()
        );
    }
}
