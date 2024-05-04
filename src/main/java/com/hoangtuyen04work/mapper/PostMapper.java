package com.hoangtuyen04work.mapper;

import java.sql.ResultSet;

import com.hoangtuyen04work.model.Post;
import com.hoangtuyen04work.model.User;

public class PostMapper implements RowMapper<Post>{


	@Override
	public Post mapRow(ResultSet resultSet) {
		try{
			Post post = new Post();
			post.setId(resultSet.getLong("id"));
			post.setIdUser(resultSet.getString("userid"));
			post.setContent(resultSet.getString("content"));
			post.setNumberComment(resultSet.getLong("numbercomment"));
			post.setNumberEmotion(resultSet.getLong("numberemotion"));

			if(resultSet.getTimestamp("createddate") != null) {
				post.setCreatedDate(resultSet.getTimestamp("createddate"));
			}
			post.setDeleteDate(resultSet.getTimestamp("deleteddate"));
			if(resultSet.getTimestamp("deleteddate") != null) {
				post.setDeleteDate(resultSet.getTimestamp("deleteddate"));
			}
			post.setState(resultSet.getLong("state"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				post.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			return post;
		}
		catch(Exception e){
			return null;
		}
	}

}
