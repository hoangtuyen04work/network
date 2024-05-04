package com.hoangtuyen04work.service;

import java.util.List;

import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;

public interface IPostService {
	List<Post>	getPosts(User user);
	Post addPost( Post post);
}
