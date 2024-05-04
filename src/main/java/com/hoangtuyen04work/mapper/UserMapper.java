package com.hoangtuyen04work.mapper;

import java.sql.ResultSet;

import com.hoangtuyen04work.model.User;

public class UserMapper implements RowMapper<User>{


	@Override
	public User mapRow(ResultSet resultSet) {
		try{
			User user = new User();
			user.setId(resultSet.getLong("id"));
			user.setUserId(resultSet.getString("userid"));
			user.setUserName(resultSet.getString("username"));
			user.setPassWord(resultSet.getString("password"));
			user.setPhoneNumber(resultSet.getString("phonenumber"));
			if(resultSet.getTimestamp("birthday") != null) {
				user.setBirthDay(resultSet.getTimestamp("birthday"));
			}
			if(resultSet.getString("birthplace") != null) {
				user.setBirthPlace(resultSet.getString("birthplace"));
			}
			if(resultSet.getString("liveplace") != null) {
				user.setLivePlace(resultSet.getString("liveplace"));
			}
			if(resultSet.getString("shortdescription") != null) {
				user.setShortDescription(resultSet.getString("shortdescription"));
			}
//			user.setType(resultSet.getString("type"));
			user.setNumberFollower(resultSet.getLong("numberfollower"));
			user.setNumberPost(resultSet.getLong("numberpost"));
			user.setNumberFollowing(resultSet.getLong("numberfollowing"));
			if(resultSet.getTimestamp("createddate") != null) {
				user.setCreatedDate(resultSet.getTimestamp("createddate"));
			}
			user.setDeleteDate(resultSet.getTimestamp("deleteddate"));
			if(resultSet.getTimestamp("deleteddate") != null) {
				user.setDeleteDate(resultSet.getTimestamp("deleteddate"));
			}
			user.setState(resultSet.getLong("state"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}

			System.out.println(user.getId());
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
			System.out.println(user.getPassWord());
			
			return user;
		}
		catch(Exception e){
			return null;
		}
	}

}
