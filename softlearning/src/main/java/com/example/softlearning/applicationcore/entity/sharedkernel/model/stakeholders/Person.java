package com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.DataCheck;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.GeneralDateTimeException;

public abstract class Person {

    protected String name, ident, address, phone;
    protected LocalDateTime birthday;
    protected boolean company;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //CONTRUCTORS
    protected Person() {
    }

    protected void checkPersonData(String name, String ident, String birthday,
            String address, String phone) throws BuildException {

        String errorMessage = "";
        if (this.setName(name) != 0) {
            errorMessage += "Bad Name;";
        }
        if (this.setIdent(ident) != 0) {
            errorMessage += "Bad Ident;";
        }
        try {
            this.setBirthday(birthday);
        } catch (GeneralDateTimeException ex) {
            errorMessage += "Bad Birthday: " + ex.getMessage() + ";";
        }
        if (this.setAddress(address) != 0) {
            errorMessage += "Bad Address;";
        }
        if (this.setPhone(phone) != 0) {
            errorMessage += "Bad Phone;";
        }
        this.company = false;

        if (errorMessage.length() > 0) {
            throw new BuildException(errorMessage);
        }
    }

    //GETTER & SETTERS
    public String getName() {
        return name;
    }

    public int setName(String nom) {
        if (DataCheck.checkString(nom, 10) != 0) {
            return -1;
        }
        //si todo ok se guarda nombre
        this.name = nom;
        return 0;
    }

    public String getIdent() {
        return ident;
    }

    public int setIdent(String ident) {
        if (DataCheck.checkString(ident, 9) != 0) {
            return -1;
        }
        this.ident = ident;
        return 0;
    }

    public String getBirthday() {
        return birthday.format(this.formatter);
    }

    public void setBirthday(String birthday) throws GeneralDateTimeException {
        this.birthday = DataCheck.convertStringToDateTime(birthday, this.formatter);
    }

    public String getAddress() {
        return address;
    }

    public int setAddress(String address) {
        if (DataCheck.checkString(address, 9) != 0) {
            return -1;
        }
        this.address = address;
        return 0;
    }

    public Boolean isCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public int setPhone(String phone) {
        if (DataCheck.checkString(phone, 9) != 0) {
            return -1;
        }
        this.phone = phone;
        return 0;
    }

    // SPECIFICS METHODS
    @Override
    public String toString() {
        return this.name + ";" + ";" + ident + ";" + this.getBirthday() + ";"
                + this.address + ";" + this.company;
    }
}
