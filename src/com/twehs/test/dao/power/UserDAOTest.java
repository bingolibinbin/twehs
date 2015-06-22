package com.twehs.test.dao.power;

import java.io.IOException;

import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.twehs.dao.power.UserDAO;
import com.twehs.pojo.User;
import com.twehs.pojo.example.UserExample;
import com.twehs.pojo.example.UserExample.Criteria;
import com.twehs.test.dao.AbstractTestCase;

public class UserDAOTest extends AbstractTestCase {

	private UserDAO userDAO;

	public UserDAOTest() {
		super();
		userDAO = (UserDAO) ctx.getBean("userDAO");
		System.out.println("userDAO" + userDAO);

	}

	public void testCountAll() throws SQLException {

		System.out.println(userDAO.countAll());
	}

}
