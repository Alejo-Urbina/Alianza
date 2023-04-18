package com.prueba.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public class InformationClient {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private Integer id;
    private String sharedKey;
    private String businessId;
    private String email;
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private Date endDate;

    public InformationClient() {
    }

    public InformationClient(Integer id, String sharedKey, String businessId, String email, String phone, Date startDate, Date endDate) {
        this.id = id;
        this.sharedKey = sharedKey;
        this.businessId = businessId;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
