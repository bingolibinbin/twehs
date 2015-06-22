package com.twehs.dao.power;

import java.sql.SQLException;
import java.util.List;

import com.twehs.pojo.RoleMenuKey;
import com.twehs.pojo.example.RoleMenuExample;

public interface RoleMenuDAO {

	int countByExample(RoleMenuExample example) throws SQLException;

	int deleteByExample(RoleMenuExample example) throws SQLException;

	int deleteByPrimaryKey(RoleMenuKey key) throws SQLException;

	Integer insert(RoleMenuKey record) throws SQLException;

	Integer insertSelective(RoleMenuKey record) throws SQLException;

	List selectByExample(RoleMenuExample example) throws SQLException;

	int updateByExampleSelective(RoleMenuKey record, RoleMenuExample example)
			throws SQLException;

	int updateByExample(RoleMenuKey record, RoleMenuExample example)
			throws SQLException;
}