package com.hoangtuyen04work.model;

import java.sql.Timestamp;

public class EmotionComment extends Model {
    private Long commentId;
    private String userId;
    private Long postId;
    

    public EmotionComment(Long postId, Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate,
            Long commentId, String userId) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
    }

    public EmotionComment(Long postId, Long commentId, String userId) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
    }

    public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

}
