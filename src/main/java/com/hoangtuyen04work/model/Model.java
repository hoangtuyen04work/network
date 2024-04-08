package com.hoangtuyen04work.model;

import java.security.Timestamp;

public class Model {
    private Long id;
    private Timestamp createdDate;
    private Timestamp deleteDate;
    private Long state;
    private Timestamp modifiedDate;

    public Model() {
    }

    public Model(Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.deleteDate = deleteDate;
        this.state = state;
        this.modifiedDate = modifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Timestamp deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }
  
    public Long getState() {
        return state;
    }
    public void setState(Long state) {
        this.state = state;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
