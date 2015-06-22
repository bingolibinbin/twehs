package com.twehs.dao.power.impl;

import com.twehs.dao.power.RoleMenuDAO;
import com.twehs.pojo.example.RoleMenuExample;
import com.twehs.pojo.RoleMenuKey;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.List;

public class RoleMenuDAOImpl implements RoleMenuDAO {

	private SqlMapClient sqlMapClient;

	public RoleMenuDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(RoleMenuExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"rolemenu.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int deleteByExample(RoleMenuExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"rolemenu.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(RoleMenuKey key) throws SQLException {
		int rows = sqlMapClient.delete(
				"rolemenu.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(RoleMenuKey record) throws SQLException {
		Object newKey = sqlMapClient.insert("rolemenu.ibatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertSelective(RoleMenuKey record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"rolemenu.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(RoleMenuExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"rolemenu.ibatorgenerated_selectByExample", example);
		return list;
	}

	public int updateByExampleSelective(RoleMenuKey record,
			RoleMenuExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"rolemenu.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(RoleMenuKey record, RoleMenuExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"rolemenu.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	private static class UpdateByExampleParms extends RoleMenuExample {
		private Object record;

		public UpdateByExampleParms(Object record, RoleMenuExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}