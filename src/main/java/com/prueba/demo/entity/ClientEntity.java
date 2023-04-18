package com.prueba.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String SHAREDKEY;
    private String BUSINESSID;
    private String EMAIL;
    private String PHONE;
    private Date STARTDATE;
    private Date ENDDATE;

    public ClientEntity() {
    }

    public ClientEntity(Integer ID, String SHAREDKEY, String BUSINESSID, String EMAIL, String PHONE, Date STARTDATE, Date ENDDATE) {
        this.ID = ID;
        this.SHAREDKEY = SHAREDKEY;
        this.BUSINESSID = BUSINESSID;
        this.EMAIL = EMAIL;
        this.PHONE = PHONE;
        this.STARTDATE = STARTDATE;
        this.ENDDATE = ENDDATE;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSHAREDKEY() {
        return SHAREDKEY;
    }

    public void setSHAREDKEY(String SHAREDKEY) {
        this.SHAREDKEY = SHAREDKEY;
    }

    public String getBUSINESSID() {
        return BUSINESSID;
    }

    public void setBUSINESSID(String BUSINESSID) {
        this.BUSINESSID = BUSINESSID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public Date getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(Date STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

    public Date getENDDATE() {
        return ENDDATE;
    }

    public void setENDDATE(Date ENDDATE) {
        this.ENDDATE = ENDDATE;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "ID=" + ID +
                ", SHAREDKEY='" + SHAREDKEY + '\'' +
                ", BUSINESSID='" + BUSINESSID + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", STARTDATE=" + STARTDATE +
                ", ENDDATE=" + ENDDATE +
                '}';
    }
}
