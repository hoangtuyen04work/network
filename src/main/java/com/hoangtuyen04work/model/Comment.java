package com.hoangtuyen04work.model;

import java.security.Timestamp;

public class Comment extends Model {
	private String idUser;
    private Long postId;
    private String content;
    private Long numberEmotion;

    public Comment() {

    }

    public Comment(String idUser, Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate,
            Long postId, String content, Long numberEmotion) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.postId = postId;
        this.content = content;
        this.numberEmotion = numberEmotion;
        this.idUser = idUser;
    }

    public Comment(String idUser, Long postId, String content, Long numberEmotion) {
        this.postId = postId;
        this.content = content;
        this.numberEmotion = numberEmotion;
        this.idUser = idUser;
    }

    public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getNumberEmotion() {
        return numberEmotion;
    }

    public void setNumberEmotion(Long emotion) {
        this.numberEmotion = emotion;
    }

}
