package com.twehs.dao.company;

import com.twehs.pojo.Company;
import com.twehs.pojo.Menu;

import com.twehs.pojo.example.CompanyExample;
import java.sql.SQLException;
import java.util.List;

public interface CompanyDAO {

	int countAll() throws SQLException;

	int countByExample(CompanyExample example) throws SQLException;

	int deleteByExample(CompanyExample example) throws SQLException;

	int deleteByPrimaryKey(Integer companyid) throws SQLException;

	Integer insert(Company record) throws SQLException;

	Integer insertSelective(Company record) throws SQLException;

	Integer insertwithid(Company record) throws SQLException;

	List selectByExample(CompanyExample example) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize) throws SQLException;

	Company selectByPrimaryKey(Integer companyid) throws SQLException;

	int updateByExampleSelective(Company record, CompanyExample example)
			throws SQLException;

	int updateByExample(Company record, CompanyExample example)
			throws SQLException;

	int updateByPrimaryKeySelective(Company record) throws SQLException;

	int updateByPrimaryKey(Company record) throws SQLException;
}