package com.example.softlearning.applicationcore.entity.client.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientDTO {
    private String name, ident, address, phone, birthday, creditcard, password, since;
    @Id
    private int code;
    private boolean premium;

    public ClientDTO(String name, String ident, String birthday, String address, String phone, 
            String creditcard, String password, int code, boolean premium, String since) {
        this.name = name;
        this.ident = ident;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.creditcard = creditcard;
        this.password = password;
        this.since = since;
        this.code = code;
        this.premium = premium;
    }

   
    public ClientDTO() {
    }

    public String getName() {
        return name;
    }

    public String getIdent() {
        return ident;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public String getPassword() {
        return password;
    }

    public String getSince() {
        return since;
    }

    public int getCode() {
        return code;
    }

    public boolean isPremium() {
        return premium;
    }

    
}
