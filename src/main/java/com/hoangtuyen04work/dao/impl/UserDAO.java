package com.hoangtuyen04work.dao.impl;

import java.sql.Timestamp;

import com.hoangtuyen04work.dao.IUserDAO;
import com.hoangtuyen04work.mapper.UserMapper;
import com.hoangtuyen04work.model.User;

public class UserDAO extends GenericDAO<User> implements IUserDAO {

	
	@Override
	public User setUser(User user) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		StringBuilder sql = new StringBuilder("INSERT INTO [user] (userid, username, password, phonenumber,");
		sql.append(" birthday, birthplace, liveplace, shortdescription, type, numberfollower, numberpost,");
		sql.append(" numberfollowing, createddate, deleteddate, state, modifieddate) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return set(sql.toString(), new UserMapper(), user.getUserId(), user.getUserName(), user.getPassWord(), user.getPhoneNumber(), user.getBirthDay(), user.getBirthPlace(), user.getLivePlace(), user.getShortDescription(), user.getType(), user.getNumberFollower(), user.getNumberPost(), user.getNumberFollowing(), currentTimestamp, null, 1, null);
	}

	@Override
	public User getUser(String idUser) {
		String sql = "SELECT * FROM [user] WHERE iduser = ?";
		return getById(sql, new UserMapper(), idUser);
		
	}

	@Override
	public User getUser(Long id) {
		String sql = "SELECT * FROM [user] WHERE id = ?";
		return getById(sql, new UserMapper(), id);
	}

	@Override
	public User findByUserId(String userId) {
		String sql = "SELECT * FROM [user] WHERE userid = ?";
		return findById(sql, new UserMapper(), userId);
	}

	@Override
	public User fildById(Long id) {
		String sql = "SELECT * FROM [user] WHERE id = ?";
		return findById(sql, new UserMapper(), id);
	}

	@Override
	public User fildByUserIdAndPassword(String userId, String password, Long state) {
		String sql = "SELECT * FROM [user] WHERE userid = ? AND password = ? AND state = ?";
		User user = null;
		user = findById(sql, new UserMapper(), userId, password, state);

		if(user == null) {
			return null;
		}
		else {
			System.out.println("Khac Null");
			return user;
		}
		
	}

	@Override
	public User fildByPhoneNumberAndPassword(String phoneNumber, String password, Long state) {
		String sql = "SELECT * FROM [user] WHERE userid = ? AND password = ? AND state = ?";
		User user = findById(sql, new UserMapper(), phoneNumber, password, state);
		if(user.getId() == null) return null;
		return user;
	}

	@Override
	public Boolean checkUserExistence(User userInput) {
		String sql = "SELECT * FROM [user] WHERE userid = ? AND username = ? AND phonenumber = ? AND state = ?";
		User user = new User();
		user = findById(sql, new UserMapper(), userInput.getUserId(), userInput.getUserName(), userInput.getPassWord(), 1l);
		if(user == null)return false;
		return true;
		
	}



	
}
