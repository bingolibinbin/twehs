package com.twehs.dao.power.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.twehs.dao.power.TypeDAO;
import com.twehs.pojo.Menu;
import com.twehs.pojo.Type;
import com.twehs.pojo.example.TypeExample;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {

	private SqlMapClient sqlMapClient;

	public TypeDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(TypeExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"ibatorgenerated_type_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("ibatorgenerated_type_countAll");
		return count.intValue();
	}

	public int deleteByExample(TypeExample example) throws SQLException {
		int rows = sqlMapClient.delete("ibatorgenerated_type_deleteByExample",
				example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer typeid) throws SQLException {
		Type key = new Type();
		key.setTypeid(typeid);
		int rows = sqlMapClient.delete(
				"ibatorgenerated_type_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Type record) throws SQLException {
		Object newKey = sqlMapClient.insert("ibatorgenerated_type_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertwithid(Type record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_type_insertwithid", record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Type record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"ibatorgenerated_type_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(TypeExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_type_selectByExample", example);
		return list;
	}

	public List listAll(Integer menuid) throws SQLException {
		// System.out.println("typeDAOmenuid:"+menuid);
		List lists = sqlMapClient.queryForList(
				"ibatorgenerated_type_selectAll", menuid);
		return lists;
	}
	
	public List listAllPro(Integer menuid) throws SQLException {
		// System.out.println("typeDAOmenuid:"+menuid);
		
		
		
		List lists = sqlMapClient.queryForList(
				"ibatorgenerated_type_selectAllPro", menuid);
		return lists;
	}

	public List selectByPaper(Integer begin, Integer pageSize)
			throws SQLException {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("begin", begin);
		param.put("pageSize", pageSize);
		List list = sqlMapClient.queryForList(
				"ibatorgenerated_type_selectByPaper", param);
		return list;
	}

	public Type selectByPrimaryKey(Integer typeid) throws SQLException {
		Type key = new Type();
		key.setTypeid(typeid);
		Type record = (Type) sqlMapClient.queryForObject(
				"ibatorgenerated_type_selectByPrimaryKey", key);
		return record;
	}

	public int updateByExampleSelective(Type record, TypeExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"ibatorgenerated_type_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Type record, TypeExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update("ibatorgenerated_type_updateByExample",
				parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Type record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_type_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Type record) throws SQLException {
		int rows = sqlMapClient.update(
				"ibatorgenerated_type_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends TypeExample {
		private Object record;

		public UpdateByExampleParms(Object record, TypeExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}