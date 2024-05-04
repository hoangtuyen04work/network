package com.hoangtuyen04work.service;

import java.util.List;

import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;

public interface IUserService {
	User addUser(User user);
	User findUserByPhoneNumber(String phoneNumber, String password, Long state);
	User findUserByUserId(String userId, String password, Long state);
	boolean checkUserExistence(User userInput);
	List<User> getAllUsers();
	List<Post> loadMorePost();
}
