package com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers;

import java.util.TreeMap;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning.applicationcore.entity.client.dtos.ClientSpanishDTO;


public class SerializersCatalog {

    private static TreeMap<Serializers, Serializer> catalog = new TreeMap<>();   

    private static void loadCatalog(){
        //AL CARREGAR EL SERIALITZADOR PASSEM PER CONSTRUCTOR L'OBJECTE AMB QUE ES REALIZARÀ LA SERIALITZACIO       
       
        catalog.put(Serializers.CLIENT_JSON, new JacksonSerializer<ClientDTO>());
        catalog.put(Serializers.CLIENT_JSON_SPANISH, new JacksonSerializer<ClientSpanishDTO>());
        catalog.put(Serializers.CLIENT_XML, new JacksonXMLSerializer<ClientDTO>());             
        catalog.put(Serializers.CLIENT_XML_SPANISH, new JacksonXMLSerializer<ClientSpanishDTO>());

    }  

    public static Serializer getInstance(Serializers type){
        if (catalog.isEmpty()){
            loadCatalog();
        }      
        return catalog.get(type);
    }   
}
