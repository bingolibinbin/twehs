package com.twehs.dao.content;

import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Message;
import com.twehs.pojo.example.MessageExample;
import java.sql.SQLException;
import java.util.List;

public interface MessageDAO {

	int countAll() throws SQLException;

	int countByExample(MessageExample example) throws SQLException;

	int deleteByExample(MessageExample example) throws SQLException;

	int deleteByPrimaryKey(Integer messageid) throws SQLException;

	Integer insert(Message record) throws SQLException;

	Integer insertSelective(Message record) throws SQLException;

	Integer insertwithid(Message record) throws SQLException;

	List selectByExample(MessageExample example) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize, String phoneno)
			throws SQLException;

	Message selectByPrimaryKey(Integer messageid) throws SQLException;

	int updateByExampleSelective(Message record, MessageExample example)
			throws SQLException;

	int updateByExample(Message record, MessageExample example)
			throws SQLException;

	int updateByPrimaryKeySelective(Message record) throws SQLException;

	int updateByPrimaryKey(Message record) throws SQLException;
}