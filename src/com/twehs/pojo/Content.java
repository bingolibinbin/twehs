package com.twehs.pojo;

import java.math.BigDecimal;

import java.util.Date;
import java.sql.Timestamp;

public class Content {

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
	
	private String smallpicaddress;
	
	private String smallpicname;
	
	private String specification;
	
	private BigDecimal price;
	
	private Boolean display;

	public Integer getContentid() {
		return contentid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public String getTitle() {
		return title;
	}

	public Boolean getTopline() {
		return topline;
	}

	public Boolean getRecommender() {
		return recommender;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public String getTypename() {
		return typename;
	}

	public String getSource() {
		return source;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public Integer getOrder() {
		return order;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public String getSmallpicaddress() {
		return smallpicaddress;
	}

	public String getSmallpicname() {
		return smallpicname;
	}

	public String getSpecification() {
		return specification;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTopline(Boolean topline) {
		this.topline = topline;
	}

	public void setRecommender(Boolean recommender) {
		this.recommender = recommender;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public void setSmallpicaddress(String smallpicaddress) {
		this.smallpicaddress = smallpicaddress;
	}

	public void setSmallpicname(String smallpicname) {
		this.smallpicname = smallpicname;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

}