package com.hoangtuyen04work.model;

import java.sql.Timestamp;

public class User extends Model {
    private String userId;
    private String userName;
    private String passWord;
    private String phoneNumber;
    private Timestamp birthDay;
    private String birthPlace;
    private String livePlace;
    private String shortDescription;
    private String type;
    private Long numberFollower;
    private Long numberPost;
    private Long numberFollowing;
    public User() {
    	super();
    	this.type = "USER";
    	this.id = -1l;
    	this.numberFollower = 1l;
    	this.numberFollowing = 1l;
    	this.numberPost = 1l;
    }

    public User(String userName, String passWord, Timestamp birthDay, String birthPlace,
            String livePlace, String shortDescription) {
        this.userName = userName;
        this.passWord = passWord;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
        this.livePlace = livePlace;
        this.shortDescription = shortDescription;
        this.type = "USER";
    }

    
    
    public Long getNumberPost() {
		return numberPost;
	}

	public void setNumberPost(Long numberPost) {
		this.numberPost = numberPost;
	}

	public Long getNumberFollowing() {
		return numberFollowing;
	}

	public void setNumberFollowing(Long numberFollowing) {
		this.numberFollowing = numberFollowing;
	}

	public Long getNumberFollower() {
		return numberFollower;
	}

	public void setNumberFollower(Long numberFollower) {
		this.numberFollower = numberFollower;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }



    

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getLivePlace() {
        return livePlace;
    }

    public void setLivePlace(String livePlace) {
        this.livePlace = livePlace;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setType() {
    	this.type = "USER";
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
