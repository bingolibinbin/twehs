package com.twehs.action.menu;

import java.util.ArrayList;

import antlr.collections.List;

import com.twehs.action.BaseAction;

import com.twehs.pojo.Menu;
import com.twehs.service.menu.dto.MenuDTO;
import com.twehs.utils.pubutil.ComboData;
import com.twehs.utils.pubutil.Page;
import com.twehs.service.menu.MenuService;
import com.twehs.service.power.UserService;

public class MenuAction extends BaseAction {

	private Integer menuid;
	private String menuname;
	private Integer pid;
	private String menuurl;
	private Integer menutype;
	private Integer ordernum;
	private String icon;

	private MenuService menuService;

	/*
	 * 查询菜单
	 */
	public String findPageMenu() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			menuService.findPageMenu(page);
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 更新和保存
	 */
	public String saveOrUpdateMenu() {
		try {
			MenuDTO dto = new MenuDTO(menuid, menuname, pid, menuurl, menutype,
					ordernum, icon);
			menuService.saveOrUpdateMenu(dto);
			if (menuid == null) {
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

	/*
	 * 删除Menu
	 */

	public String deleteMenu() {
		try {
			boolean b = menuService.deleteMenu(menuid);
			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该栏目已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该栏目已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 查询Menu类型
	 */
	public String findMenuType() {
		java.util.List list = new ArrayList();
		try {
			Integer menutypee = 1; // 在type中要使用到；
			java.util.List<Menu> departmentList = menuService
					.findMenuType(menutypee);
			for (Menu department : departmentList) {
				ComboData dto = new ComboData();
				dto.setValue(department.getMenuid().toString());
				dto.setText(department.getMenuname());
				list.add(dto);
			}
			this.outListString(list);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
