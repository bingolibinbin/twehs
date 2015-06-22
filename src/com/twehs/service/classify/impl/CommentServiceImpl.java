package com.twehs.service.classify.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.twehs.dao.content.CommentDAO;
import com.twehs.dao.content.ContentDAO;
import com.twehs.dao.content.MessageDAO;
import com.twehs.pojo.Comment;
import com.twehs.pojo.Content;
import com.twehs.service.classify.CommentService;
import com.twehs.service.classify.dto.CommentDTO;
import com.twehs.service.classify.dto.MessageDTO;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.utils.pubutil.Page;

public class CommentServiceImpl implements CommentService {

	// private ContentDAO contentDAO;
	private CommentDAO commentDAO;

	/*
	 * 分页查询
	 */
	public void findPageComments(Page page, String title) throws SQLException {

		/*
		 * List list1 = contentDAO.selectByContentid(title); List<Comment>
		 * dtoListAll= new ArrayList<Comment>(); Iterator<Content> itr =
		 * list1.iterator(); while (itr.hasNext()) { Content
		 * itr1=(Content)itr.next(); Integer citr = itr1.getContentid();
		 * List<Comment> listcomment = commentDAO.selectByPaper(page.getStart(),
		 * page.getLimit(), citr);
		 * 
		 * @SuppressWarnings("rawtypes") Iterator<Comment> itr2 =
		 * listcomment.iterator(); while(itr2.hasNext()) {
		 * dtoListAll.add(itr2.next()); } } List<CommentDTO> dtoList =
		 * CommentDTO.createDtos(dtoListAll); int total = commentDAO.countAll();
		 * //这里countAll是自己改写的，本身不提供这个函数 page.setTotal(total);
		 * page.setRoot(dtoList);
		 */

		List<Comment> listComment = commentDAO.selectByPaper(page.getStart(),
				page.getLimit(), title);
		@SuppressWarnings("rawtypes")
		List<CommentDTO> dtoList = CommentDTO.createDtos(listComment);
		int total = commentDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);

	}

	/*
	 * 删除操作
	 */
	public boolean deleteComments(Integer commentid) throws SQLException {
		try {
			// System.out.println("删除操作:"+contentid);
			commentDAO.deleteByPrimaryKey(commentid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * 暂时还没写
	 */
	// checkComments
	public boolean checkComments(List commentList) throws SQLException {
		// commentDAO.updateByPrimaryKey(null); //自己写对应的方法；
		if (commentList.size() != 0)

		{
			// System.out.println("service层"+commentList.get(0));
			commentDAO.updateByCheck(commentList);
			return true;
		} else
			return false;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

}
