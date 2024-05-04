package com.hoangtuyen04work.model;

import java.sql.Timestamp;

public class Post extends Model{
    private String idUser;
    private String content;
    private Long numberEmotion;
    private Long numberComment;
    
    public Long getNumberComment() {
		return numberComment;
	}
	public void setNumberComment(Long numberComment) {
		this.numberComment = numberComment;
	}
	public Post() {
 
    }
	public Post(String idUser, String content, Long numberEmotion) {
        this.idUser = idUser;
        this.content = content;
        this.numberEmotion = numberEmotion;
    }
    public Post(Long numberEmotion, Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate, String idUser,
            String content) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.idUser = idUser;
        this.content = content;
        this.numberEmotion = numberEmotion;
    }
    public Post(Long numberEmotion, Long id, Timestamp createdDate, Timestamp deleteDate, Long state, Timestamp modifiedDate,
            String content) {
        super(id, createdDate, deleteDate, state, modifiedDate);
        this.content = content;
        this.numberEmotion = numberEmotion;
    }
    
    
    public Long getNumberEmotion() {
		return numberEmotion;
	}
	public void setNumberEmotion(Long numberEmotion) {
		this.numberEmotion = numberEmotion;
	}
	public Post(String content) {
        this.content = content;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
}
