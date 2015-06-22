package com.twehs.service.power;

import java.sql.SQLException;

import com.twehs.service.power.dto.UserDTO;
import com.twehs.utils.pubutil.Page;

public interface UserService {

	/**
	 * 登录验证
	 * 
	 * @throws SQLException
	 */
	public UserDTO login(String code, String pass) throws SQLException;

	/**
	 * 分页查询用户列表
	 * 
	 * @throws SQLException
	 */
	public void findPageUser(Page page) throws SQLException;

	/**
	 * 保存/修改用户
	 * 
	 * @throws SQLException
	 */
	public boolean saveOrUpdateUser(UserDTO dto) throws SQLException;

	/**
	 * 删除用户
	 */
	public void deleteUser(Integer userid);

}
