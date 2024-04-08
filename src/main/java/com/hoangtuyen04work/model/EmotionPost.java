package com.hoangtuyen04work.model;

import java.security.Timestamp;

public class EmotionPost extends Model{
    private Long postId;
    private Long userId;
    

    
    public EmotionPost(Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate,
            Long postId, Long userId) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.postId = postId;
        this.userId = userId;
    }

    public EmotionPost(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
}
