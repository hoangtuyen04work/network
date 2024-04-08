package com.hoangtuyen04work.model;

import java.security.Timestamp;

public class Network extends Model{
    private String link;
    private String nameSocialNetwork;

    public Network(){
        
    }
    
    public Network(Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate,
            String link, String nameSocialNetwork) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.link = link;
        this.nameSocialNetwork = nameSocialNetwork;
    }
    public Network(String link, String nameSocialNetwork) {
        this.link = link;
        this.nameSocialNetwork = nameSocialNetwork;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getNameSocialNetwork() {
        return nameSocialNetwork;
    }
    public void setNameSocialNetwork(String nameSocialNetwork) {
        this.nameSocialNetwork = nameSocialNetwork;
    }
}
