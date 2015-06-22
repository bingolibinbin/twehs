package com.twehs.dao.content.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.twehs.dao.content.EmployeeDAO;
import com.twehs.pojo.Employee;
import com.twehs.pojo.Message;
import com.twehs.pojo.NewsFind;
import com.twehs.pojo.example.EmployeeExample;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SqlMapClient sqlMapClient;

	public EmployeeDAOImpl() {
		super();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public int countByExample(EmployeeExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"employee.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	public int countAll() throws SQLException {
		Integer count = (Integer) sqlMapClient
				.queryForObject("employee.ibatorgenerated_countAll");
		return count.intValue();
	}

	public int deleteByExample(EmployeeExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"employee.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer employeeid) throws SQLException {
		Employee key = new Employee();
		key.setEmployeeid(employeeid);
		int rows = sqlMapClient.delete(
				"employee.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	public Integer insert(Employee record) throws SQLException {
		Object newKey = sqlMapClient.insert("employee.ibatorgenerated_insert",
				record);
		return (Integer) newKey;
	}

	public Integer insertwithid(Employee record) throws SQLException {

		Date date2 = record.getOperatetime();
		Timestamp time = (Timestamp) date2;
		record.setOperatetime(time);
		// 这里必须要date类型转换，否则ibatis无法识别；
		Object newKey = sqlMapClient.insert(
				"employee.ibatorgenerated_insertwithid", record);
		return (Integer) newKey;
	}

	public Integer insertSelective(Employee record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"employee.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	public List selectByExample(EmployeeExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"employee.ibatorgenerated_selectByExample", example);
		return list;
	}

	public List selectByPaper(Integer begin, Integer pageSize, String title)
			throws SQLException {
		NewsFind messagee = new NewsFind();
		messagee.setTitle(title);
		messagee.setBegin(begin);
		messagee.setPageSize(pageSize);
		// 输入时newscomment

		List list = sqlMapClient.queryForList(
				"employee.ibatorgenerated_selectByPaper", messagee);
		return list;
	}

	public Employee selectByPrimaryKey(Integer employeeid) throws SQLException {
		Employee key = new Employee();
		key.setEmployeeid(employeeid);
		Employee record = (Employee) sqlMapClient.queryForObject(
				"employee.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	public int updateByExampleSelective(Employee record, EmployeeExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"employee.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(Employee record, EmployeeExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"employee.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	public int updateByPrimaryKeySelective(Employee record) throws SQLException {
		int rows = sqlMapClient.update(
				"employee.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Employee record) throws SQLException {
		int rows = sqlMapClient.update(
				"employee.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	private static class UpdateByExampleParms extends EmployeeExample {
		private Object record;

		public UpdateByExampleParms(Object record, EmployeeExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}