package com.example.softlearning.applicationcore.entity.client.mappers;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientSpanishDTO;
import com.example.softlearning.applicationcore.entity.client.model.Client;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ClientSpanishMapper {

    public static Client clientFromDTO(ClientSpanishDTO cdto) throws BuildException {       
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
    public static ClientSpanishDTO dtoFromClient(Client c) {
        return new ClientSpanishDTO(   c.getName(), 
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
