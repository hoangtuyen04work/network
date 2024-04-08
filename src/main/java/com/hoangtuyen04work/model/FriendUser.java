package com.hoangtuyen04work.model;

import java.security.Timestamp;

public class FriendUser extends Model {
	private String friendId;

	public FriendUser() {
		
	}
	
	public FriendUser(Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate) {
		super(id, createdDate, deleteDate, state, modifiedDate);
		// TODO Auto-generated constructor stub
	}

	public FriendUser(String friendId) {
		super();
		this.friendId = friendId;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	
}
