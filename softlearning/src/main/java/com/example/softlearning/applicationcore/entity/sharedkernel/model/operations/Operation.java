package com.example.softlearning.applicationcore.entity.sharedkernel.model.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.DataCheck;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.GeneralDateTimeException;

public abstract class Operation {
    protected int ref;
    protected String description;
    protected LocalDateTime startDate, finishDate;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");

    protected Operation() {
    }
    
    public void checkData(int id, String startDate, String description) throws BuildException{
        
        if (this.setRef(id) == -1) {
            throw new BuildException("Bad id;");
        }
       try { 
            setStartDate (startDate);
        } catch (GeneralDateTimeException ex) {
            throw new BuildException(ex.getMessage());
        }
        this.description = description;

    }

            
    public int getRef() {
        return this.ref;
    }

    public int setRef(int ident) {
        if (DataCheck.checkNumber(ident, 1000) != 0) {
            return -1;
        }
        this.ref = ident;
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStartDate() {
        if (startDate == null) {
            return null;
        }
        return startDate.format(this.formatter); 
    }

    public void setStartDate(String startDate) throws GeneralDateTimeException {        
        if (startDate == null) {
            throw new GeneralDateTimeException("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        }
        this.startDate = DataCheck.convertStringToDateTime(startDate, this.formatter);
    }

    public String getFinishDate() {
        if (finishDate == null) {
            return null;
        }
        return finishDate.format(this.formatter); 
    }

    public void setFinishDate(String finishDate) throws GeneralDateTimeException {
        if (finishDate == null) {
            throw new GeneralDateTimeException("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        }
        this.finishDate = DataCheck.convertStringToDateTime(finishDate, this.formatter);
    }  
}