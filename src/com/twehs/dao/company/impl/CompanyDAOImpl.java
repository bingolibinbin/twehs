package com.twehs.dao.company.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.twehs.dao.company.CompanyDAO;
import com.twehs.pojo.Company;
import com.twehs.pojo.Menu;
import com.twehs.pojo.example.CompanyExample;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

	private SqlMapClient sqlMapClient;

	public CompanyDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(CompanyExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"company.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("company.ibatorgenerated_countAll");
		return count.intValue();
	}

	public int deleteByExample(CompanyExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"company.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer companyid) throws SQLException {
		Company key = new Company();
		key.setCompanyid(companyid);
		int rows = sqlMapClient.delete(
				"company.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Company record) throws SQLException {
		Object newKey = sqlMapClient.insert("company.ibatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertwithid(Company record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"company.ibatorgenerated_insertwithid", record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Company record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"company.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(CompanyExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"company.ibatorgenerated_selectByExample", example);
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize)
			throws SQLException {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("begin", begin);
		param.put("pageSize", pageSize);
		List list = sqlMapClient.queryForList(
				"company.ibatorgenerated_selectByPaper", param);
		return list;
	}

	public Company selectByPrimaryKey(Integer companyid) throws SQLException {
		Company key = new Company();
		key.setCompanyid(companyid);
		Company record = (Company) sqlMapClient.queryForObject(
				"company.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	public int updateByExampleSelective(Company record, CompanyExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"company.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Company record, CompanyExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"company.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Company record) throws SQLException {
		int rows = sqlMapClient.update(
				"company.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Company record) throws SQLException {
		int rows = sqlMapClient.update(
				"company.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends CompanyExample {
		private Object record;

		public UpdateByExampleParms(Object record, CompanyExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}