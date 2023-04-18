package com.prueba.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ResponseSaveClientTest {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    LocalDate startDate;

    public ResponseSaveClientTest() {
    }

    public ResponseSaveClientTest(Integer id, LocalDate startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
