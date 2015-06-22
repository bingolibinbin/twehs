package com.twehs.dao.content.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.twehs.dao.content.CommentDAO;
import com.twehs.pojo.Comment;
import com.twehs.pojo.NewsFind;
import com.twehs.pojo.example.CommentExample;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

	private SqlMapClient sqlMapClient;

	public CommentDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(CommentExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"comment.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("comment.ibatorgenerated_countAll");
		return count.intValue();
	}

	public int deleteByExample(CommentExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"comment.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer commentid) throws SQLException {
		Comment key = new Comment();
		key.setCommentid(commentid);
		int rows = sqlMapClient.delete(
				"comment.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Comment record) throws SQLException {
		Object newKey = sqlMapClient.insert("comment.ibatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Comment record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"comment.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(CommentExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"comment.ibatorgenerated_selectByExample", example);
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize, String title)
			throws SQLException {
		NewsFind newscomment = new NewsFind();
		newscomment.setTitle(title);
		newscomment.setBegin(begin);
		newscomment.setPageSize(pageSize);
		// 输入时newscomment
		List list = sqlMapClient.queryForList(
				"comment.ibatorgenerated_selectByPaper", newscomment);
		return list;
	}

	public Comment selectByPrimaryKey(Integer commentid) throws SQLException {
		Comment key = new Comment();
		key.setCommentid(commentid);
		Comment record = (Comment) sqlMapClient.queryForObject(
				"comment.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	public int updateByExampleSelective(Comment record, CommentExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"comment.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Comment record, CommentExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"comment.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Comment record) throws SQLException {
		int rows = sqlMapClient.update(
				"comment.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Comment record) throws SQLException {
		int rows = sqlMapClient.update(
				"comment.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	public boolean updateByCheck(List commentList) throws SQLException {
		System.out.println("DAO层：" + commentList);
		Iterator it = commentList.iterator();
		while (it.hasNext()) {
			sqlMapClient.update("comment.ibatorgenerated_updateByCheck",
					it.next());
			System.out.println("返回结果：");
		}
		return true;
	}

	private static class UpdateByExampleParms extends CommentExample {
		private Object record;

		public UpdateByExampleParms(Object record, CommentExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}