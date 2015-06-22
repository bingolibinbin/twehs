package com.twehs.action.power;

import com.twehs.action.BaseAction;
import com.twehs.service.power.RoleService;
import com.twehs.service.power.dto.RoleDTO;
import com.twehs.utils.pubutil.Page;

@SuppressWarnings("serial")
public class RoleAction extends BaseAction {

	private Integer roleid;
	private String rolename;
	private String bz;
	private String menuids;

	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * 分页查询角色
	 */
	public String findPageRole() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			roleService.findPageRole(page); // 有问题，无法转换
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 保存/修改角色
	 */
	public String saveOrUpdateRole() {
		try {
			RoleDTO dto = new RoleDTO(roleid, rolename, bz);
			roleService.saveOrUpdateRole(dto);
			if (roleid == null) {
				this.outString("{success:true,message:'保存成功!'}");
			} else {
				this.outString("{success:true,message:'修改成功!'}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 删除角色
	 */
	public String deleteRole() {
		try {
			boolean b = roleService.deleteRole(roleid);
			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该角色已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该角色已被使用，不能删除'}");
		}
		return null;
	}

	/**
	 * 角色下拉数据
	 */
	public String findRoleType() {
		try {
			this.outListString(roleService.findRoleType());
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 角色权限菜单
	 */
	public String findRoleMenu() {
		try {
			this.outTreeJsonList(roleService.findRoleMenu(roleid));
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 保存角色权限
	 */
	public String saveRoleMenu() {
		try {
			roleService.saveRoleMenu(roleid, menuids);
			this.outString("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}
}
