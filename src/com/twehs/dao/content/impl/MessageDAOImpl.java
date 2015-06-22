package com.twehs.dao.content.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.twehs.dao.content.MessageDAO;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Message;
import com.twehs.pojo.NewsFind;
import com.twehs.pojo.example.MessageExample;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {

	private SqlMapClient sqlMapClient;

	public MessageDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(MessageExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"message.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("message.ibatorgenerated_countAll");
		return count.intValue();
	}

	public int deleteByExample(MessageExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"message.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer messageid) throws SQLException {
		Message key = new Message();
		key.setMessageid(messageid);
		int rows = sqlMapClient.delete(
				"message.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Message record) throws SQLException {
		Object newKey = sqlMapClient.insert("message.ibatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Message record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"message.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public Integer insertwithid(Message record) throws SQLException {

		Date date2 = record.getOperatetime();
		Timestamp time = (Timestamp) date2;
		record.setOperatetime(time);
		// 这里必须要date类型转换，否则ibatis无法识别；
		Object newKey = sqlMapClient.insert(
				"message.ibatorgenerated_insertwithid", record);
		return (Integer) newKey;
	}

	public List selectByExample(MessageExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"message.ibatorgenerated_selectByExample", example);
		return list;
	}

	public Message selectByPrimaryKey(Integer messageid) throws SQLException {
		Message key = new Message();
		key.setMessageid(messageid);
		Message record = (Message) sqlMapClient.queryForObject(
				"message.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	public List selectByPaper(Integer begin, Integer pageSize, String phoneno)
			throws SQLException {
		NewsFind messagee = new NewsFind();
		messagee.setTitle(phoneno);
		messagee.setBegin(begin);
		messagee.setPageSize(pageSize);
		// 输入时newscomment

		List list = sqlMapClient.queryForList(
				"message.ibatorgenerated_selectByPaper", messagee);
		return list;
	}

	public int updateByExampleSelective(Message record, MessageExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"message.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Message record, MessageExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"message.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Message record) throws SQLException {
		int rows = sqlMapClient.update(
				"message.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Message record) throws SQLException {
		int rows = sqlMapClient.update(
				"message.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends MessageExample {
		private Object record;

		public UpdateByExampleParms(Object record, MessageExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}