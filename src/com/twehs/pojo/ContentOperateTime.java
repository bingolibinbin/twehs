package com.twehs.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ContentOperateTime {

	private Integer contentid;

	private Integer menuid;

	private String title;

	private Boolean topline;

	private Boolean recommender;

	private Integer typeid;

	private String typename; // 需要连表操作；

	private String source;

	private String author;

	private String content;

	private Integer order;

	private Date operatetime;

	// private Integer operatetime = null;
	private String smallpicaddress;

	private String smallpicname;

	private String specification;

	private BigDecimal price;

	private Boolean display;

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getTopline() {
		return topline;
	}

	public void setTopline(Boolean topline) {
		this.topline = topline;
	}

	public Boolean getRecommender() {
		return recommender;
	}

	public void setRecommender(Boolean recommender) {
		this.recommender = recommender;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getSmallpicaddress() {
		return smallpicaddress;
	}

	public void setSmallpicaddress(String smallpicaddress) {
		this.smallpicaddress = smallpicaddress;
	}

	public String getSmallpicname() {
		return smallpicname;
	}

	public void setSmallpicname(String smallpicname) {
		this.smallpicname = smallpicname;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	} // 这里专门写为致空

	/*
	 * public void setOperatetime(Timestamp operatetime) { this.operatetime =
	 * operatetime; }
	 */

}