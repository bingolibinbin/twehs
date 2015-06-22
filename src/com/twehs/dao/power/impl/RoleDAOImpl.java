package com.twehs.dao.power.impl;

import com.twehs.dao.power.RoleDAO;
import com.twehs.pojo.Role;

import com.twehs.pojo.example.RoleExample;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

	private SqlMapClient sqlMapClient;

	public RoleDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(RoleExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"ibatorgenerated_role_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("ibatorgenerated_role_countAll");
		return count.intValue();
	}

	public int deleteByExample(RoleExample example) throws SQLException {
		int rows = sqlMapClient.delete("ibatorgenerated_role_deleteByExample",
				example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer roleid) throws SQLException {
		Role key = new Role();
		key.setRoleid(roleid);
		int rows = sqlMapClient.delete(
				"role.ibatorgenerated_role_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Role record) throws SQLException {
		Object newKey = sqlMapClient.insert("ibatorgenerated_role_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Role record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_role_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(RoleExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_role_selectByExample", example);
		return list;
	}

	public List selectAll() throws SQLException {
		List list = sqlMapClient.queryForList("ibatorgenerated_role_selectAll");
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize)
			throws SQLException {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("begin", begin);
		param.put("pageSize", pageSize);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_role_selectByPaper", param);
		return list;
	}

	public Role selectByPrimaryKey(Integer roleid) throws SQLException {
		Role key = new Role();
		key.setRoleid(roleid);
		Role record = (Role) sqlMapClient.queryForObject(
				"ibatorgenerated_role_selectroleByPrimaryKey", roleid);
		return record;
	}

	public int updateByExampleSelective(Role record, RoleExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"ibatorgenerated_role_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Role record, RoleExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("ibatorgenerated_role_updateByExample",
				parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Role record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_role_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Role record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_role_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends RoleExample {
		private Object record;

		public UpdateByExampleParms(Object record, RoleExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}