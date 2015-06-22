package com.twehs.action.power;

import com.twehs.action.BaseAction;
import com.twehs.service.power.UserService;
import com.twehs.service.power.dto.UserDTO;
import com.twehs.utils.pubutil.Page;
import com.twehs.utils.system.Constants;

public class UserAction extends BaseAction {

	private Integer userid;
	private String logincode;
	private String password;
	private String username;
	private Integer roleid;
	private Integer state;
	private String bz;

	private UserService userService;

	/**
	 * 
	 * 登录验证
	 * 
	 */
	public String login() {
		try {
			String code = logincode.trim().toLowerCase();
			String pass = password.trim().toLowerCase();
			UserDTO userInfo = userService.login(pass, code);

			if (userInfo != null) {
				this.getSession().setAttribute(Constants.USERINFO, userInfo);
				return "success";
			} else {
				this.getRequest().setAttribute("error", "用户名或密码错误");
				return "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.getRequest().setAttribute("error", "连接失败");
			return "login";
		}
	}

	/**
	 * 
	 * 用户权限菜单
	 */
	public String getMenuBuf() {
		UserDTO userInfo = this.getUserDTO();
		try {
			if (userInfo != null) {
				this.outString(userInfo.getUsermenu());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 分页查询用户列表
	 * 
	 */
	public String findPageUser() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			userService.findPageUser(page);
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 保存/修改用户
	 */
	public String saveOrUpdateUser() {
		try {
			UserDTO dto = new UserDTO(userid, logincode, password, username,
					roleid, null, state, bz);
			boolean bool = userService.saveOrUpdateUser(dto);
			if (bool) {
				if (userid == null) {
					this.outString("{success:true,message:'保存成功!'}");
				} else {
					this.outString("{success:true,message:'修改成功!'}");
				}
			} else {
				this.outString("{success:false,errors:'用户账号已存在!'}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/**
	 * 删除用户
	 */
	public String deleteUser() {
		try {
			userService.deleteUser(userid);
			this.outString("{success:true}");
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
