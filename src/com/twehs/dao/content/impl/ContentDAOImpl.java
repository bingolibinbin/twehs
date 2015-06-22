package com.twehs.dao.content.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.twehs.dao.content.ContentDAO;
import com.twehs.pojo.Content;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.NewsFind;
import com.twehs.pojo.Type;
import com.twehs.pojo.example.ContentExample;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentDAOImpl implements ContentDAO {

	private SqlMapClient sqlMapClient;

	public ContentDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(ContentExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"ibatorgenerated_content_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("ibatorgenerated_content_countAll");
		return count.intValue();
	}

	public int countByTypeid(int typeid) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"ibatorgenerated_content_countByTypeid", typeid);
		return count.intValue();
	}

	public int deleteByExample(ContentExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"ibatorgenerated_content_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer contentid) throws SQLException {
		Content key = new Content();
		key.setContentid(contentid);
		int rows = sqlMapClient.delete(
				"ibatorgenerated_content_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Content record) throws SQLException {
		Object newKey = sqlMapClient.insert("ibatorgenerated_content_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertwithid(ContentOperateTime record) throws SQLException {

		Date date2 = record.getOperatetime();
		Timestamp time = (Timestamp) date2;
		record.setOperatetime(time);
		// 这里必须要date类型转换，否则ibatis无法识别；
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_content_insertwithid", record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Content record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_content_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(ContentExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_content_selectByExample", example);
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize, String title,
			Integer typeid) throws SQLException {
		// NewFind 是为了传输 title, typeid ,begin ,pagesize 设置的传输类，也可以直接写成DTO形式
		NewsFind newsfind = new NewsFind();
		newsfind.setTitle(title);
		newsfind.setTypeid(typeid);
		newsfind.setBegin(begin);
		newsfind.setPageSize(pageSize);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_content_selectByPaper", newsfind);

		return list;
	}

	public Content selectByPrimaryKey(Integer contentid) throws SQLException {
		Content key = new Content();
		key.setContentid(contentid);
		Content record = (Content) sqlMapClient.queryForObject(
				"ibatorgenerated_content_selectByPrimaryKey", key);
		return record;
	}

	public List selectByContentid(String title) throws SQLException {
		Content key = new Content();
		key.setTitle(title);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_content_selectByContentid", key);
		return list;

	}

	public int updateByExampleSelective(Content record, ContentExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"ibatorgenerated_content_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Content record, ContentExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"ibatorgenerated_content_updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(ContentOperateTime record)
			throws SQLException {
		Date date3 = record.getOperatetime();
		Timestamp time1 = new Timestamp(date3.getTime());
		// 这里做Date类型向TimeStamp转换
		record.setOperatetime(time1);
		// 这里必须要date类型转换，否则ibatis无法识别；
		int rows = sqlMapClient.update(
				"ibatorgenerated_content_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Content record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_content_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends ContentExample {
		private Object record;

		public UpdateByExampleParms(Object record, ContentExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}