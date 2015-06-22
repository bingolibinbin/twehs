package com.twehs.service.power;

import java.sql.SQLException;
import java.util.List;

import com.twehs.service.power.dto.RoleDTO;
import com.twehs.utils.pubutil.Page;

@SuppressWarnings("unchecked")
public interface RoleService {

	/**
	 * 分页查询角色列表
	 * 
	 * @throws SQLException
	 */
	public void findPageRole(Page page) throws SQLException;

	/**
	 * 保存/修改角色
	 * 
	 * @throws SQLException
	 */
	public void saveOrUpdateRole(RoleDTO dto) throws SQLException;

	/**
	 * 删除角色
	 * 
	 * @throws SQLException
	 */
	public boolean deleteRole(Integer roleid) throws SQLException;

	/**
	 * 角色下拉数据
	 * 
	 * @throws SQLException
	 */

	public List findRoleType() throws SQLException;

	/**
	 * 查询角色菜单
	 * 
	 * @throws SQLException
	 */
	public List findRoleMenu(Integer roleid) throws SQLException;

	/**
	 * 保存角色权限
	 * 
	 * @throws SQLException
	 */
	public void saveRoleMenu(Integer roleid, String menuids)
			throws SQLException;

}
