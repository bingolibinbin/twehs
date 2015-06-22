package com.twehs.dao.content;

import com.twehs.pojo.Comment;

import com.twehs.pojo.example.CommentExample;
import java.sql.SQLException;
import java.util.List;

public interface CommentDAO {

	int countAll() throws SQLException;

	int countByExample(CommentExample example) throws SQLException;

	int deleteByExample(CommentExample example) throws SQLException;

	int deleteByPrimaryKey(Integer commentid) throws SQLException;

	Integer insert(Comment record) throws SQLException;

	Integer insertSelective(Comment record) throws SQLException;

	List selectByExample(CommentExample example) throws SQLException;

	Comment selectByPrimaryKey(Integer commentid) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize, String title)
			throws SQLException;

	int updateByExampleSelective(Comment record, CommentExample example)
			throws SQLException;

	int updateByExample(Comment record, CommentExample example)
			throws SQLException;

	int updateByPrimaryKeySelective(Comment record) throws SQLException;

	int updateByPrimaryKey(Comment record) throws SQLException;

	boolean updateByCheck(List commentList) throws SQLException;
}