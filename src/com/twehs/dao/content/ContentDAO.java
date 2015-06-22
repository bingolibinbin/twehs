package com.twehs.dao.content;

import com.twehs.pojo.Content;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Type;

import com.twehs.pojo.example.ContentExample;
import java.sql.SQLException;
import java.util.List;

public interface ContentDAO {
	int countAll() throws SQLException;

	int countByTypeid(int typeid) throws SQLException;

	int countByExample(ContentExample example) throws SQLException;

	int deleteByExample(ContentExample example) throws SQLException;

	int deleteByPrimaryKey(Integer contentid) throws SQLException;

	Integer insert(Content record) throws SQLException;

	Integer insertwithid(ContentOperateTime record) throws SQLException;

	Integer insertSelective(Content record) throws SQLException;

	List selectByExample(ContentExample example) throws SQLException;

	public List selectByPaper(Integer begin, Integer pageSize, String title,
			Integer typeid) throws SQLException;

	Content selectByPrimaryKey(Integer contentid) throws SQLException;

	List selectByContentid(String title) throws SQLException;

	int updateByExampleSelective(Content record, ContentExample example)
			throws SQLException;

	int updateByExample(Content record, ContentExample example)
			throws SQLException;

	int updateByPrimaryKeySelective(ContentOperateTime record)
			throws SQLException;

	int updateByPrimaryKey(Content record) throws SQLException;

}