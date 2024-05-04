package com.hoangtuyen04work.service.impl;
import java.util.List;

import javax.inject.Inject;

//import javax.inject.Inject;
import com.hoangtuyen04work.dao.IUserDAO;
import com.hoangtuyen04work.dao.impl.UserDAO;
import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;
import com.hoangtuyen04work.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;
	

	@Override
	public User addUser(User user) {
		return userDAO.setUser(user);
	}
	@Override
	public User findUserByPhoneNumber(String phoneNumber, String password, Long state) {
		return userDAO.fildByPhoneNumberAndPassword(phoneNumber, password, state);
	}
	@Override
	public User findUserByUserId(String userId, String password, Long state) {
		return userDAO.fildByUserIdAndPassword(userId, password, state);

	}
	@Override
	public boolean checkUserExistence(User userInput) {
		return userDAO.checkUserExistence(userInput);
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Post> loadMorePost() {
		// TODO Auto-generated method stub
		return null;
	}

}
