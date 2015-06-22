package com.twehs.dao.content;

import com.twehs.pojo.Message;
import com.twehs.pojo.Nodification;

import com.twehs.pojo.example.NodificationExample;
import java.sql.SQLException;
import java.util.List;

public interface NodificationDAO {

	int countAll() throws SQLException;

	int countByExample(NodificationExample example) throws SQLException;

	int deleteByExample(NodificationExample example) throws SQLException;

	int deleteByPrimaryKey(Integer notificationid) throws SQLException;

	Integer insert(Nodification record) throws SQLException;

	Integer insertSelective(Nodification record) throws SQLException;

	Integer insertwithid(Nodification record) throws SQLException;

	List selectByExample(NodificationExample example) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize, String notification)
			throws SQLException;

	Nodification selectByPrimaryKey(Integer notificationid) throws SQLException;

	int updateByExampleSelective(Nodification record,
			NodificationExample example) throws SQLException;

	int updateByExample(Nodification record, NodificationExample example)
			throws SQLException;

	int updateByPrimaryKeySelective(Nodification record) throws SQLException;

	int updateByPrimaryKey(Nodification record) throws SQLException;
}