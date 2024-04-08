package com.hoangtuyen04work.model;

public class Follower extends Model {
	private String followerId;

	public Follower() {
		
	}
	
	public Follower(String followerid) {
		super();
		this.followerId = followerid;
	}

	public String getIdFolower() {
		return followerId;
	}

	public void setIdFolower(String followerid) {
		this.followerId = followerid;
	}
	
	
}
