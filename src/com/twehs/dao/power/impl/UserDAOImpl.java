package com.twehs.dao.power.impl;

import com.twehs.pojo.User;

import com.twehs.pojo.example.UserExample;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.twehs.dao.power.UserDAO;

import java.io.Reader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO {

	private SqlMapClient sqlMapClient;

	public UserDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {

		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("ibatorgenerated_user_countAll");
		return count.intValue();
	}

	public int countByExample(UserExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"ibatorgenerated_user_countByExample", example);
		return count.intValue();
	}

	public int deleteByExample(UserExample example) throws SQLException {
		int rows = sqlMapClient.delete("ibatorgenerated_user_deleteByExample",
				example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer userid) throws SQLException {
		User key = new User();
		key.setUserid(userid);
		int rows = sqlMapClient.delete(
				"ibatorgenerated_user_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(User record) throws SQLException {
		Object newKey = sqlMapClient.insert("ibatorgenerated_user_insert",
				record);
		return (Integer) newKey;
	}

	public List selectByExample(UserExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_user_selectByExample", example);
		return list;

	}

	public List selectByPaper(Integer begin, Integer pageSize)
			throws SQLException {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("begin", begin);
		param.put("pageSize", pageSize);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_user_selectByPaper", param);
		return list;

	}

	public User selectByLoginCode(String logincode) throws SQLException {
		User key = new User();
		key.setLogincode(logincode);
		User record = (User) sqlMapClient.queryForObject(
				"ibatorgenerated_user_selectByloginCode", key);
		return record;
	}

	public User selectByPrimaryKey(Integer userid) throws SQLException {
		User key = new User();
		key.setUserid(userid);
		User record = (User) sqlMapClient.queryForObject(
				"ibatorgenerated_user_selectByPrimaryKey", key);
		return record;
	}

	public User selectByPrimarypassword(String pass, String code)
			throws SQLException {
		User key = new User();
		key.setPassword(pass);
		key.setLogincode(code);
		User record = (User) sqlMapClient.queryForObject(
				"ibatorgenerated_user_selectByPrimarypassword", key);
		return record;
	}

	// 对DAO层的改写；
	public User selectByroleid(Integer roleid) throws SQLException {
		User key = new User();
		key.setRoleid(roleid);
		User record = (User) sqlMapClient.queryForObject(
				"ibatorgenerated_user_selectByroleid", key);
		return record;
	}

	private static class UpdateByExampleParms extends UserExample {
		private Object record;

		public UpdateByExampleParms(Object record, UserExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	public Integer insertSelective(com.twehs.pojo.User record)
			throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_user_insertSelective", record);
		return (Integer) newKey;
	}

	public int updateByExample(com.twehs.pojo.User record, UserExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("ibatorgenerated_user_updateByExample",
				parms);
		return rows;
	}

	public int updateByExampleSelective(com.twehs.pojo.User record,
			UserExample example) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(com.twehs.pojo.User record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_user_updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(User record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_user_updateByPrimaryKeySelective", record);
		return rows;
	}
}
