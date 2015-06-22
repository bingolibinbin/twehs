package com.twehs.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class NewsFind {

	// private Integer contentid;
	// private Integer menuid;
	   private String title;
	// private Boolean topline;
	// private Boolean recommender;
	   private Integer typeid;
	// private String typename; //需要连表操作；
	/*
	 * private String source; private String author; private String content;
	 * private Integer order; private Date operatetime; private String
	 * smallpicaddress; private String smallpicname; private String
	 * specification; private BigDecimal price; private Boolean display;
	 */
	   private Integer begin;
	   private Integer pageSize;

	public NewsFind(String title, Integer typeid, Integer begin,
			Integer pageSize) {
		super();
		this.title = title;
		this.typeid = typeid;
		this.begin = begin;
		this.pageSize = pageSize;
	}

	/*
	 * public NewsFind(Integer contentid, Integer menuid, String title, Boolean
	 * topline, Boolean recommender, Integer typeid, String source, String
	 * author, String content, Integer order, Date operatetime, String
	 * smallpicaddress, String smallpicname, String specification, BigDecimal
	 * price, Boolean display, Integer begin, Integer pageSize) { super();
	 * this.contentid = contentid; this.menuid = menuid; this.title = title;
	 * this.topline = topline; this.recommender = recommender; this.typeid =
	 * typeid; this.source = source; this.author = author; this.content =
	 * content; this.order = order; this.operatetime = operatetime;
	 * this.smallpicaddress = smallpicaddress; this.smallpicname = smallpicname;
	 * this.specification = specification; this.price = price; this.display =
	 * display; this.begin = begin; this.pageSize = pageSize; }
	 */

	public NewsFind() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public Integer getContentid() { return contentid; } public void
	 * setContentid(Integer contentid) { this.contentid = contentid; } public
	 * Integer getMenuid() { return menuid; } public void setMenuid(Integer
	 * menuid) { this.menuid = menuid; }
	 */

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * public Boolean getTopline() { return topline; } public void
	 * setTopline(Boolean topline) { this.topline = topline; } public Boolean
	 * getRecommender() { return recommender; } public void
	 * setRecommender(Boolean recommender) { this.recommender = recommender; }
	 */
	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	/*
	 * public String getSource() { return source; } public void setSource(String
	 * source) { this.source = source; } public String getAuthor() { return
	 * author; } public void setAuthor(String author) { this.author = author; }
	 * public String getContent() { return content; } public void
	 * setContent(String content) { this.content = content; } public Integer
	 * getOrder() { return order; } public void setOrder(Integer order) {
	 * this.order = order; } public Date getOperatetime() { return operatetime;
	 * } public void setOperatetime(Date operatetime) { this.operatetime =
	 * operatetime; } public String getSmallpicaddress() { return
	 * smallpicaddress; } public void setSmallpicaddress(String smallpicaddress)
	 * { this.smallpicaddress = smallpicaddress; } public String
	 * getSmallpicname() { return smallpicname; } public void
	 * setSmallpicname(String smallpicname) { this.smallpicname = smallpicname;
	 * } public String getSpecification() { return specification; } public void
	 * setSpecification(String specification) { this.specification =
	 * specification; } public BigDecimal getPrice() { return price; } public
	 * void setPrice(BigDecimal price) { this.price = price; } public Boolean
	 * getDisplay() { return display; } public void setDisplay(Boolean display)
	 * { this.display = display; }
	 */
	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
