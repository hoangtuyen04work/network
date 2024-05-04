package com.hoangtuyen04work.dao;

import java.util.List;

import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;

public interface IPostDAO extends IGenericDAO {
	public List<Post> getPosts(User user);
	public Post addPost( Post post);
}
