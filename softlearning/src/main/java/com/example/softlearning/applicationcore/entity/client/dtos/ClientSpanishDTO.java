package com.example.softlearning.applicationcore.entity.client.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Cliente")
//@JsonIgnoreProperties({ "contraseña", "tarjeta_credito" })
public class ClientSpanishDTO {
    @JacksonXmlProperty(localName = "Nombre")
    private String name;
    @JacksonXmlProperty(localName = "DNI")
    private String ident;
    @JacksonXmlProperty(localName = "Direccion")
    private String address;
    @JacksonXmlProperty(localName = "Telefono")
    private String phone;
    @JacksonXmlProperty(localName = "Fecha_nacimiento")
    private String birthday;
    @JacksonXmlProperty(localName = "Tarjeta_credito")
    private String creditcard;
    @JacksonXmlProperty(localName = "Contraseña")
    private String password;
    @JacksonXmlProperty(localName = "Fecha_alta")
    private String since;
    @JacksonXmlProperty(localName = "Codigo")
    private int code;
    @JacksonXmlProperty(localName = "Destacado")
    private boolean premium;
    @JacksonXmlProperty(localName = "Empresa")
    private boolean company;

    public ClientSpanishDTO(String name, String ident, String birthday, String address, String phone,
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
        this.company = false;
    }

    public ClientSpanishDTO() {
    }

    @JsonGetter("nombre")
    @JacksonXmlProperty(localName = "Nombre")
    public String getName() {
        return name;
    }

    @JsonGetter("ident")
    @JacksonXmlProperty(localName = "DNI")
    public String getIdent() {
        return ident;
    }

    @JsonGetter("direccion")
    @JacksonXmlProperty(localName = "Direccion")
    public String getAddress() {
        return address;
    }

    @JsonGetter("telefono")
    @JacksonXmlProperty(localName = "Telefono")
    public String getPhone() {
        return phone;
    }

    @JsonGetter("fecha_nacimiento")
    @JacksonXmlProperty(localName = "Fecha_nacimiento")
    public String getBirthday() {
        return birthday;
    }

    @JsonGetter("tarjeta_credito")
    @JacksonXmlProperty(localName = "Tarjeta_credito")
    public String getCreditcard() {
        return creditcard;
    }

    @JsonGetter("contraseña")
    @JacksonXmlProperty(localName = "Contraseña")
    public String getPassword() {
        return password;
    }

    @JsonGetter("fecha_alta")
    @JacksonXmlProperty(localName = "Fecha_alta")
    public String getSince() {
        return since;
    }

    @JsonGetter("codigo")
    @JacksonXmlProperty(localName = "Codigo")
    public int getCode() {
        return code;
    }

    @JsonGetter("destacado")
    @JacksonXmlProperty(localName = "Destacado")
    public boolean isPremium() {
        return premium;
    }

    @JsonGetter("empresa")
    @JacksonXmlProperty(localName = "Empresa")
    public boolean isCompany() {
        return company;
    }

        @JsonSetter("nombre")
    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("ident")
    public void setIdent(String ident) {
        this.ident = ident;
    }

    @JsonSetter("direccion")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonSetter("telefono")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonSetter("fecha_nacimiento")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonSetter("tarjeta_credito")
    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    @JsonSetter("contraseña")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonSetter("fecha_alta")
    public void setSince(String since) {
        this.since = since;
    }

    @JsonSetter("codigo")
    public void setCode(int code) {
        this.code = code;
    }

    @JsonSetter("destacado")
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @JsonSetter("empresa")
    public void setCompany(boolean company) {
        this.company = company;
    }

}
