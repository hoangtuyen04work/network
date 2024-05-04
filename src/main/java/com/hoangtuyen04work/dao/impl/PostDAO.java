package com.hoangtuyen04work.dao.impl;

import java.util.List;
import java.util.Random;

import com.hoangtuyen04work.dao.IPostDAO;
import com.hoangtuyen04work.mapper.PostMapper;
import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;

public class PostDAO extends GenericDAO implements IPostDAO {

	@Override
	public List<Post> getPosts(User user) {
		String sql = "SELECT * FROM post WHERE userid = ? ORDER BY createddate DESC";
		List<Post> posts = getList(sql, new PostMapper(), user.getUserId());
		return posts;
	}

	@Override
	public Post addPost( Post post) {
		// radom idpost because in sql server, i don't set auto increment for post id
		Random radom = new Random();
		int x = radom.nextInt(1000000000);
		String sql = "INSERT INTO post(id, userid, content, createddate) VALUES (?, ?, ?, ?)";
		return (Post)set(sql, new PostMapper(), x, post.getIdUser(), post.getContent(), post.getCreatedDate());
	}

}