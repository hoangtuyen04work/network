package com.hoangtuyen04work.model;

import java.sql.Timestamp;

public class Relation extends Model {
    private String relationId;
    private String relationName;

    public Relation(){
        
    }
    public Relation(Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate,
            String relationId, String relationName) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.relationId = relationId;
        this.relationName = relationName;
    }

    public Relation(String relationId, String relationName) {
        this.relationId = relationId;
        this.relationName = relationName;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

}
