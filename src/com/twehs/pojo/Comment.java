package com.twehs.pojo;

import java.util.Date;

public class Comment {

	private Integer commentid;
	
	private Integer contentid;
	
	private String commentscontent;
	
	private String commentor;
	
	private Boolean display;
	
	private Boolean check;
	
	private Date operatetime;
	
	private String title; // 外加的，链表获得

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public String getCommentscontent() {
		return commentscontent;
	}

	public void setCommentscontent(String commentscontent) {
		this.commentscontent = commentscontent;
	}

	public String getCommentor() {
		return commentor;
	}

	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}