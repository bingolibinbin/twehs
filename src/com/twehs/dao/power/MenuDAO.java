package com.twehs.dao.power;

import com.twehs.pojo.Menu;
import com.twehs.pojo.example.MenuExample;
import java.sql.SQLException;
import java.util.List;

public interface MenuDAO {

	int countAll() throws SQLException;

	int countByExample(MenuExample example) throws SQLException;

	int deleteByExample(MenuExample example) throws SQLException;

	int deleteByPrimaryKey(Integer menuid) throws SQLException;

	Integer insert(Menu record) throws SQLException;

	Integer insertwithid(Menu record) throws SQLException;

	Integer insertSelective(Menu record) throws SQLException;

	List selectByExample(MenuExample example) throws SQLException;

	Menu selectByPrimaryKey(Integer menuid) throws SQLException;

	List selectByMenuType(Integer menutype) throws SQLException;

	List selectByPaper(Integer begin, Integer pageSize) throws SQLException;

	int updateByExampleSelective(Menu record, MenuExample example)
			throws SQLException;

	int updateByExample(Menu record, MenuExample example) throws SQLException;

	int updateByPrimaryKeySelective(Menu record) throws SQLException;

	int updateByPrimaryKey(Menu record) throws SQLException;
}