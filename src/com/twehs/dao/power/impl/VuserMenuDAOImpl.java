package com.twehs.dao.power.impl;

import com.twehs.dao.power.VuserMenuDAO;
import com.twehs.pojo.VuserMenu;

import com.twehs.pojo.example.VuserMenuExample;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.List;

public class VuserMenuDAOImpl implements VuserMenuDAO {

	private SqlMapClient sqlMapClient;

	public VuserMenuDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(VuserMenuExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"vusermenu.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int deleteByExample(VuserMenuExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"vusermenu.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public Integer insert(VuserMenu record) throws SQLException {
		Object newKey = sqlMapClient.insert("vusermenu.ibatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertSelective(VuserMenu record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"vusermenu.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(VuserMenuExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"vusermenu.ibatorgenerated_selectByExample", example);
		return list;
	}

	public int updateByExampleSelective(VuserMenu record,
			VuserMenuExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"vusermenu.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(VuserMenu record, VuserMenuExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"vusermenu.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	private static class UpdateByExampleParms extends VuserMenuExample {
		private Object record;

		public UpdateByExampleParms(Object record, VuserMenuExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}