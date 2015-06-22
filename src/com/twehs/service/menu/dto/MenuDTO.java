package com.twehs.service.menu.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.twehs.pojo.Menu;

;

public class MenuDTO {

	private Integer menuid;
	private String menuname;
	private Integer pid;
	private String menuurl;
	private Integer menutype;
	private Integer ordernum;
	private String icon;

	public MenuDTO(Integer menuid, String menuname, Integer pid,
			String menuurl, Integer menutype, Integer ordernum, String icon) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.pid = pid;
		this.menuurl = menuurl;
		this.menutype = menutype;
		this.ordernum = ordernum;
		this.icon = icon;
	}

	public MenuDTO() {
		super();
	}

	public static MenuDTO createDto(Menu pojo) {
		MenuDTO dto = null;
		if (pojo != null) {
			dto = new MenuDTO(pojo.getMenuid(), pojo.getMenuname(),
					pojo.getPid(), pojo.getMenuurl(), pojo.getMenutype(),
					pojo.getOrdernum(), pojo.getIcon());
		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Menu menu = (Menu) iterator.next(); //
				MenuDTO dto = createDto(menu);
				list.add(dto);
			}
		}
		return list;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public Integer getMenutype() {
		return menutype;
	}

	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
