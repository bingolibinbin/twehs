package com.twehs.service.classify.dto;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.twehs.pojo.Content;

public class SolutionsDTO {

	private Integer contentid;

	private Integer typeid;
	private String typename;
	private String title;
	private Date operatetime;
	private boolean display;
	private String smallpicaddress;
	private String smallpicname;
	private String content;

	public SolutionsDTO() {
		super();
	}

	public SolutionsDTO(Integer contentid, Integer typeid, String typename,
			String title, Date operatetime, boolean display,
			String smallpicaddress, String smallpicname, String content) {
		super();
		this.contentid = contentid;
		this.typeid = typeid;
		this.typename = typename;
		this.title = title;
		this.operatetime = operatetime;
		this.display = display;
		this.smallpicaddress = smallpicaddress;
		this.smallpicname = smallpicname;
		this.content = content;
	}

	public static SolutionsDTO createDto(Content pojo) {
		SolutionsDTO dto = null;
		if (pojo != null) {
			dto = new SolutionsDTO(pojo.getContentid(), pojo.getTypeid(),
					pojo.getTypename(), pojo.getTitle(), pojo.getOperatetime(),
					pojo.getDisplay(), pojo.getSmallpicaddress(),
					pojo.getSmallpicname(), pojo.getContent());

		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<SolutionsDTO> list = new ArrayList<SolutionsDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Content solutions = (Content) iterator.next();
				SolutionsDTO dto = createDto(solutions);
				list.add(dto);
			}
		}
		return list;
	}

	public Integer getContentid() {
		return contentid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public String getTypename() {
		return typename;
	}

	public String getTitle() {
		return title;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public boolean isDisplay() {
		return display;
	}

	public String getSmallpicaddress() {
		return smallpicaddress;
	}

	public String getSmallpicname() {
		return smallpicname;
	}

	public String getContent() {
		return content;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public void setSmallpicaddress(String smallpicaddress) {
		this.smallpicaddress = smallpicaddress;
	}

	public void setSmallpicname(String smallpicname) {
		this.smallpicname = smallpicname;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
