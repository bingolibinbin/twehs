package com.twehs.service.menu.dto;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.twehs.pojo.Type;

public class TypeDTO {

	private Integer typeid;
	private Integer menuid;
	private String menuname;
	private String typename;
	private String bz;

	public TypeDTO() {
		super();
	}

	public TypeDTO(Integer typeid, Integer menuid, String menuname,
			String typename, String bz) {
		super();
		this.typeid = typeid;
		this.menuid = menuid;
		this.typename = typename;
		this.menuname = menuname;
		this.bz = bz;
	}

	public TypeDTO(Integer typeid, Integer menuid, String typename, String bz) {
		super();
		this.typeid = typeid;
		this.menuid = menuid;
		this.typename = typename;
		this.bz = bz;
	}

	public static TypeDTO createDto(Type pojo) {
		TypeDTO dto = null;
		if (pojo != null) {
			dto = new TypeDTO(pojo.getTypeid(), pojo.getMenuid(),
					pojo.getMenuname(), pojo.getTypename(), pojo.getBz());
		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<TypeDTO> list = new ArrayList<TypeDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Type type = (Type) iterator.next();
				TypeDTO dto = createDto(type);
				list.add(dto);
			}
		}
		return list;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

}
