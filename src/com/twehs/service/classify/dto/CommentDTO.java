package com.twehs.service.classify.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.twehs.pojo.Comment;
import com.twehs.pojo.Content;

public class CommentDTO {

	private Integer commentid;
	private Integer cintentid;
	private String title;
	private String commentor;
	private String commentscontent;
	private boolean display;
	private boolean check;
	private Date operatetime;

	public CommentDTO() {
		super();
	}

	public CommentDTO(Integer commentid, Integer cintentid, String commentor,
			String commentscontent, boolean display, boolean check,
			Date operatetime, String title) {
		super();
		this.commentid = commentid;
		this.cintentid = cintentid;
		this.commentor = commentor;
		this.commentscontent = commentscontent;
		this.display = display;
		this.check = check;
		this.operatetime = operatetime;
		this.title = title;
	}

	// 注意这里，如果有那一项是可以为空值的理论上要专门写一个对应的构造函数；

	public static CommentDTO createDto(Comment pojo) {
		CommentDTO dto = null;
		if (pojo != null) {
			dto = new CommentDTO(pojo.getCommentid(), pojo.getContentid(),
					pojo.getCommentor(), pojo.getCommentscontent(),
					pojo.getDisplay(), pojo.getCheck(), pojo.getOperatetime(),
					pojo.getTitle());
		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Comment news = (Comment) iterator.next();
				CommentDTO dto = createDto(news);
				list.add(dto);
			}
		}
		return list;
	}

	public Integer getCommentid() {
		return commentid;
	}

	public Integer getCintentid() {
		return cintentid;
	}

	public String getTitle() {
		return title;
	}

	public String getCommentor() {
		return commentor;
	}

	public String getCommentscontent() {
		return commentscontent;
	}

	public boolean isDisplay() {
		return display;
	}

	public boolean isCheck() {
		return check;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public void setCintentid(Integer cintentid) {
		this.cintentid = cintentid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}

	public void setCommentscontent(String commentscontent) {
		this.commentscontent = commentscontent;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

}
