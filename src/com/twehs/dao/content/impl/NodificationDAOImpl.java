package com.twehs.dao.content.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.twehs.dao.content.NodificationDAO;
import com.twehs.pojo.Message;
import com.twehs.pojo.NewsFind;
import com.twehs.pojo.Nodification;
import com.twehs.pojo.example.NodificationExample;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NodificationDAOImpl implements NodificationDAO {

	private SqlMapClient sqlMapClient;

	public NodificationDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(NodificationExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"nodification.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("nodification.ibatorgenerated_countAll");
		return count.intValue();
	}

	public int deleteByExample(NodificationExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"nodification.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer notificationid) throws SQLException {
		Nodification key = new Nodification();
		key.setNotificationid(notificationid);
		int rows = sqlMapClient.delete(
				"nodification.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Nodification record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"nodification.ibatorgenerated_insert", record);
		return (Integer) newKey;
	}

	public Integer insertwithid(Nodification record) throws SQLException {

		Date date2 = record.getOperatetime();
		Timestamp time = (Timestamp) date2;
		record.setOperatetime(time);
		// 这里必须要date类型转换，否则ibatis无法识别；
		Object newKey = sqlMapClient.insert(
				"nodification.ibatorgenerated_insertwithid", record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Nodification record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"nodification.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(NodificationExample example)
			throws SQLException {
		List list = sqlMapClient.queryForList(
				"nodification.ibatorgenerated_selectByExample", example);
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize,
			String notification) throws SQLException {
		NewsFind messagee = new NewsFind();
		messagee.setTitle(notification);
		messagee.setBegin(begin);
		messagee.setPageSize(pageSize);
		// 输入时newscomment
		List list = sqlMapClient.queryForList(
				"nodification.ibatorgenerated_selectByPaper", messagee);
		return list;
	}

	public Nodification selectByPrimaryKey(Integer notificationid)
			throws SQLException {
		Nodification key = new Nodification();
		key.setNotificationid(notificationid);
		Nodification record = (Nodification) sqlMapClient.queryForObject(
				"nodification.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	public int updateByExampleSelective(Nodification record,
			NodificationExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"nodification.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Nodification record, NodificationExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"nodification.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Nodification record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"nodification.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public int updateByPrimaryKey(Nodification record) throws SQLException {
		int rows = sqlMapClient.update(
				"nodification.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends NodificationExample {
		private Object record;

		public UpdateByExampleParms(Object record, NodificationExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}