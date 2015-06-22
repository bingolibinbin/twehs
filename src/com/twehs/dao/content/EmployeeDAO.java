package com.twehs.dao.content;

import com.twehs.pojo.Employee;
import com.twehs.pojo.Message;

import com.twehs.pojo.example.EmployeeExample;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	int countAll() throws SQLException;

	int countByExample(EmployeeExample example) throws SQLException;

	int deleteByExample(EmployeeExample example) throws SQLException;

	int deleteByPrimaryKey(Integer employeeid) throws SQLException;

	Integer insert(Employee record) throws SQLException;

	Integer insertwithid(Employee record) throws SQLException;

	Integer insertSelective(Employee record) throws SQLException;

	List selectByExample(EmployeeExample example) throws SQLException;

	Employee selectByPrimaryKey(Integer employeeid) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize, String title)
			throws SQLException;

	int updateByExampleSelective(Employee record, EmployeeExample example)
			throws SQLException;

	int updateByExample(Employee record, EmployeeExample example)
			throws SQLException;

	int updateByPrimaryKeySelective(Employee record) throws SQLException;

	int updateByPrimaryKey(Employee record) throws SQLException;
}