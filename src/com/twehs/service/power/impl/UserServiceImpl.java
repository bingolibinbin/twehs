package com.twehs.service.power.impl;

import java.sql.SQLException;

import java.util.List;

import net.sf.json.JSONArray;

import com.twehs.service.power.UserService;
import com.twehs.service.power.dto.UserDTO;

import com.twehs.pojo.example.VuserMenuExample;
import com.twehs.dao.power.*;
import com.twehs.service.power.dto.UserMenuDTO;
import com.twehs.pojo.Role;
import com.twehs.pojo.User;
import com.twehs.pojo.VuserMenu;
import com.twehs.utils.pubutil.Page;
import com.twehs.dao.power.UserDAO;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;
	private VuserMenuDAO vuserDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public VuserMenuDAO getVuserDao() {
		return vuserDao;
	}

	public void setVuserDao(VuserMenuDAO vuserDao) {
		this.vuserDao = vuserDao;
	}

	public void setBaseDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/*
	 * 登录验证
	 */
	@SuppressWarnings("unchecked")
	public UserDTO login(String pass, String code) throws SQLException {

		User user = userDao.selectByPrimarypassword(pass, code); // 获取对应的用户

		if (user != null) {
			UserDTO dto = UserDTO.createDto(user);

			VuserMenuExample vUserMenuExample = new VuserMenuExample();
			VuserMenuExample.Criteria vUserMenuCriteria = vUserMenuExample
					.createCriteria();
			vUserMenuCriteria.andUseridEqualTo(user.getUserid());
			List<VuserMenu> list = vuserDao.selectByExample(vUserMenuExample);

			JSONArray jsong = JSONArray.fromObject(new UserMenuDTO().getTree(0,
					list));

			dto.setUsermenu(jsong.toString());

			return dto;
		}
		return null;
	}

	/*
	 * 分页查询用户列表
	 */
	@SuppressWarnings("unchecked")
	public void findPageUser(Page page) throws SQLException {
		// 查询用户列表

		List<User> listUser = userDao.selectByPaper(page.getStart(),
				page.getLimit());

		List dtoList = UserDTO.createDtos(listUser);
		int total = userDao.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);
	}

	public boolean saveOrUpdateUser(UserDTO dto) throws SQLException {
		User user = new User();
		if (dto.getUserid() != null) {
			user = (User) userDao.selectByPrimaryKey(dto.getUserid()); // 找出是否已经存在这个userid更新操作
			user.setLogincode(dto.getLogincode());
			user.setPassword(dto.getPassword());
			user.setUsername(dto.getUsername());
			user.setRole(new Role(dto.getRoleid()));
			user.setRoleid(dto.getRoleid());
			user.setState(0);
			user.setBz(dto.getBz());
			userDao.updateByPrimaryKeySelective(user); // 数据库更新
		} else {
			User newUser = userDao.selectByLoginCode(dto.getLogincode()); // 找出logincode对应的User
																			// 保存操作
			if (newUser != null) {
				return false; // 用户名已经存在
			}
			user.setLogincode(dto.getLogincode());
			user.setPassword(dto.getPassword());
			user.setUsername(dto.getUsername());
			user.setRole(new Role(dto.getRoleid()));
			user.setRoleid(dto.getRoleid());
			user.setState(0);
			user.setBz(dto.getBz());
			userDao.insert(user); // 数据库更新

		}
		return true;
	}

	/*
	 * 删除用户
	 */
	public void deleteUser(Integer userid) {
		try {
			userDao.deleteByPrimaryKey(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
