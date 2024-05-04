package com.hoangtuyen04work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.hoangtuyen04work.dao.impl.PostDAO;
import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;
import com.hoangtuyen04work.service.IPostService;

public class PostService implements IPostService{
	@Inject
	PostDAO postDAO;
	@Override
	public List<Post> getPosts(User user) {
		List<Post> posts = new ArrayList<>();
		posts = postDAO.getPosts(user);
		return posts;
	}
	@Override
	public Post addPost(Post post) {
		return postDAO.addPost( post);
	}

}
