package com.example.softlearning.applicationcore.entity.client.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface ClientServices {
    public String getClientByIdToJson (int id) throws ServiceException;
    public String getClientByIdToXml (int id) throws ServiceException;
    public String newClientFromJson (String client) throws ServiceException;
    public String newClientFromXml (String client) throws ServiceException;
    public String updateOneFromJson(String client) throws ServiceException;
    public String updateOneFromXml(String client) throws ServiceException;
    public void deleteById(int id) throws ServiceException;
}
