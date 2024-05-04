package com.hoangtuyen04work.dao;

import com.hoangtuyen04work.model.User;
public interface IUserDAO extends IGenericDAO<User> {
	User setUser(User user);
	User getUser(String idUser);
	User getUser(Long id);
	User findByUserId(String userId);
	User fildById(Long id);
	User fildByUserIdAndPassword(String userId, String password, Long state);
	User fildByPhoneNumberAndPassword(String phoneNumber, String password, Long state);
	Boolean checkUserExistence(User user);

}
