package com.twehs.action.classify;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.CommentService;
import com.twehs.service.classify.dto.CommentDTO;
//import com.twehs.service.menu.TypeService;
//import com.twehs.service.menu.dto.TypeDTO;
//import com.twehs.utils.pubutil.Page;

import com.twehs.service.classify.impl.CommentServiceImpl;
import com.twehs.utils.pubutil.Page;

public class CommentAction extends BaseAction {

	private Integer commentid;
	private Integer cintentid;
	private String title;
	private String commentor;
	private String commentscontent;
	private boolean display;
	private boolean check;
	private Date operatetime;
	private String commentids;
	private CommentServiceImpl commentService;

	/*
	 * 
	 * 分页约束查询评论
	 */
	public String findPageComments() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			commentService.findPageComments(page, title); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除评论
	 */
	public String deleteComments() {
		try {
			String[] result = commentids.split(",");
			if (result.length > 1) {
				this.outString("{success:false,error:'不能同时删除多个评论'}");
			}
			int commentid = Integer.valueOf(commentids);
			// 注意这样写有风险，注意规避，就是如果误操作同时选中多个来删除将导致删除其他评论
			boolean b = commentService.deleteComments(commentid);
			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该评论已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该评论已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 
	 * 批量审核判断
	 */
	public String checkComments() throws SQLException {
		// 输出ckeck项为一的所有新闻
		String abc = commentids;
		String[] array = abc.split(",");
		List<String> commentList = new ArrayList<String>();
		for (String str : array) {
			commentList.add(str);
		}
		// 这里是从String 转换成List;
		boolean bn = commentService.checkComments(commentList);
		if (bn) {
			this.outString("{success:true}");
		} else {
			this.outString("{sucess:false,error:'已经审核过。不能重复'}");
		}

		return null;
	}

	public CommentServiceImpl getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentServiceImpl commentService) {
		this.commentService = commentService;
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

	public String getCommentids() {
		return commentids;
	}

	public void setCommentids(String commentids) {
		this.commentids = commentids;
	}

}
