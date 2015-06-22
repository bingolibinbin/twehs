package com.twehs.service.classify.dto;

import java.util.ArrayList;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.twehs.pojo.Content;

public class SupportDTO {

	private Integer contentid;
	private Integer typeid;
	private String typename;
	private String title;
	private Date operatetime;
	private boolean display;
	private String content;

	public SupportDTO() {
		super();
	}

	public SupportDTO(Integer contentid, Integer typeid, String typename,
			String title, Date operatetime, boolean display, String content) {
		super();
		this.contentid = contentid;
		this.typeid = typeid;
		this.typename = typename;
		this.title = title;
		this.operatetime = operatetime;
		this.display = display;
		this.content = content;
	}

	public static SupportDTO createDto(Content pojo) {
		SupportDTO dto = null;
		if (pojo != null) {
			dto = new SupportDTO(pojo.getContentid(), pojo.getTypeid(),
					pojo.getTypename(), pojo.getTitle(), pojo.getOperatetime(),
					pojo.getDisplay(), pojo.getContent());

		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<SupportDTO> list = new ArrayList<SupportDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Content sup = (Content) iterator.next();
				SupportDTO dto = createDto(sup);
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

	public void setContent(String content) {
		this.content = content;
	}

}
