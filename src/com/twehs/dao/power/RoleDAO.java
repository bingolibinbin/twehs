package com.twehs.dao.power;

import java.sql.SQLException;
import java.util.List;

import com.twehs.pojo.Role;
import com.twehs.pojo.example.RoleExample;

public interface RoleDAO {

	int countAll() throws SQLException;

	int countByExample(RoleExample example) throws SQLException;

	int deleteByExample(RoleExample example) throws SQLException;

	int deleteByPrimaryKey(Integer roleid) throws SQLException;

	Integer insert(Role record) throws SQLException;

	Integer insertSelective(Role record) throws SQLException;

	List selectByExample(RoleExample example) throws SQLException;

	List selectAll() throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize) throws SQLException; // 外加

	Role selectByPrimaryKey(Integer roleid) throws SQLException;

	int updateByExampleSelective(Role record, RoleExample example)
			throws SQLException;

	int updateByExample(Role record, RoleExample example) throws SQLException;

	int updateByPrimaryKeySelective(Role record) throws SQLException;

	int updateByPrimaryKey(Role record) throws SQLException;
}