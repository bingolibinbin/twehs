package com.twehs.dao.power;

import java.io.Reader;

import java.sql.SQLException;
import java.util.List;

import com.twehs.pojo.User;
import com.twehs.pojo.example.UserExample;

public interface UserDAO {
	// 外加的
	int countAll() throws SQLException;

	int countByExample(UserExample example) throws SQLException;

	int deleteByExample(UserExample example) throws SQLException;

	int deleteByPrimaryKey(Integer userid) throws SQLException;

	Integer insert(User record) throws SQLException;

	User selectByPrimarypassword(String code, String pass) throws SQLException;

	Integer insertSelective(User record) throws SQLException;

	List selectByExample(UserExample example) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize) throws SQLException;

	User selectByPrimaryKey(Integer userid) throws SQLException;

	User selectByLoginCode(String logincode) throws SQLException;

	// 后期加入的
	User selectByroleid(Integer roleid) throws SQLException;

	int updateByExampleSelective(User record, UserExample example)
			throws SQLException;

	int updateByExample(User record, UserExample example) throws SQLException;

	int updateByPrimaryKeySelective(User record) throws SQLException;

	int updateByPrimaryKey(User record) throws SQLException;
}