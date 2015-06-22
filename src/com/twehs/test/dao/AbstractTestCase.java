package com.twehs.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AbstractTestCase extends TestCase {
	protected ApplicationContext ctx = null;

	public AbstractTestCase() {
		// 测试工作流
		// ctx = new
		// ClassPathXmlApplicationContext("testApplicationContext.xml");
		// 测试DAO
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
