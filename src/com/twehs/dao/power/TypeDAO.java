package com.twehs.dao.power;

import com.twehs.pojo.Menu;

import com.twehs.pojo.Type;

import com.twehs.pojo.example.TypeExample;
import java.sql.SQLException;
import java.util.List;

public interface TypeDAO {

	int countAll() throws SQLException;

	int countByExample(TypeExample example) throws SQLException;

	int deleteByExample(TypeExample example) throws SQLException;

	int deleteByPrimaryKey(Integer typeid) throws SQLException;

	Integer insert(Type record) throws SQLException;

	Integer insertwithid(Type record) throws SQLException;

	Integer insertSelective(Type record) throws SQLException;

	List selectByExample(TypeExample example) throws SQLException;

	List listAll(Integer menuid) throws SQLException;
	
	List listAllPro(Integer menuid) throws SQLException;

	Type selectByPrimaryKey(Integer typeid) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize) throws SQLException;

	int updateByExampleSelective(Type record, TypeExample example)
			throws SQLException;

	int updateByExample(Type record, TypeExample example) throws SQLException;

	int updateByPrimaryKeySelective(Type record) throws SQLException;

	int updateByPrimaryKey(Type record) throws SQLException;
}