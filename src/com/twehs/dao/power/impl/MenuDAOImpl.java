package com.twehs.dao.power.impl;

import com.twehs.dao.power.MenuDAO;

import com.twehs.pojo.Menu;

import com.twehs.pojo.example.MenuExample;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {

	private SqlMapClient sqlMapClient;

	public MenuDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(MenuExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"ibatorgenerated_menu_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("ibatorgenerated_menu_countAll");
		return count.intValue();
	}

	public int deleteByExample(MenuExample example) throws SQLException {
		int rows = sqlMapClient.delete("ibatorgenerated_menu_deleteByExample",
				example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer menuid) throws SQLException {
		Menu key = new Menu();
		key.setMenuid(menuid);
		int rows = sqlMapClient.delete(
				"ibatorgenerated_menu_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Menu record) throws SQLException {
		Object newKey = sqlMapClient.insert("ibatorgenerated_menu_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertwithid(Menu record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_menu_insertwithid", record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Menu record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_menu_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(MenuExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_menu_selectByExample", example);
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize)
			throws SQLException {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("begin", begin);
		param.put("pageSize", pageSize);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_menu_selectByPaper", param);
		return list;
	}

	public Menu selectByPrimaryKey(Integer menuid) throws SQLException {
		Menu key = new Menu();
		key.setMenuid(menuid);
		Menu record = (Menu) sqlMapClient.queryForObject(
				"ibatorgenerated_menu_selectByPrimaryKey", key);
		return record;
	}

	public List selectByMenuType(Integer menutype) throws SQLException {
		Menu key = new Menu();
		// key.setMenuid(menuid);
		key.setMenutype(menutype);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_menu_selectByMenuType", key);
		return list;
	}

	public int updateByExampleSelective(Menu record, MenuExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"ibatorgenerated_menu_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Menu record, MenuExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("ibatorgenerated_menu_updateByExample",
				parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Menu record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_menu_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Menu record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_menu_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends MenuExample {
		private Object record;

		public UpdateByExampleParms(Object record, MenuExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}