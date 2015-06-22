package com.twehs.dao.power;

import java.sql.SQLException;
import java.util.List;

import com.twehs.pojo.example.VuserMenuExample;
import com.twehs.pojo.VuserMenu;

public interface VuserMenuDAO {

	int countByExample(VuserMenuExample example) throws SQLException;

	int deleteByExample(VuserMenuExample example) throws SQLException;

	Integer insert(VuserMenu record) throws SQLException;

	Integer insertSelective(VuserMenu record) throws SQLException;

	List selectByExample(VuserMenuExample example) throws SQLException;

	int updateByExampleSelective(VuserMenu record, VuserMenuExample example)
			throws SQLException;

	int updateByExample(VuserMenu record, VuserMenuExample example)
			throws SQLException;
}