package com.twehs.service.classify.dto;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.twehs.pojo.Content;

public class NewsDTO {

	private Integer contentid;
	private String title;
	private boolean topline;
	private boolean recommender;
	private Integer typeid;
	private String typename;
	private String source;
	private String author;
	private String content;
	private Integer order;
	private Date operatetime;
	private boolean display;

	public NewsDTO() {
		super();
	}

	public NewsDTO(Integer contentid, boolean topline, boolean recommender,
			Integer typeid, String typename, String source, String author,
			String content, Integer order, Date operatetime, boolean display,
			String title) {
		// 这里没有顺序问题
		super();
		this.contentid = contentid;
		this.topline = topline;
		this.recommender = recommender;
		this.typeid = typeid;
		this.typename = typename;
		this.source = source;
		this.author = author;
		this.content = content;
		this.order = order;
		this.operatetime = operatetime;
		this.display = display;
		this.title = title;
	}

	public static NewsDTO createDto(Content pojo) {
		NewsDTO dto = null;
		if (pojo != null) {
			dto = new NewsDTO(pojo.getContentid(), pojo.getTopline(),
					pojo.getRecommender(), pojo.getTypeid(),
					pojo.getTypename(), pojo.getSource(), pojo.getAuthor(),
					pojo.getContent(), pojo.getOrder(), pojo.getOperatetime(),
					pojo.getDisplay(), pojo.getTitle());

		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<NewsDTO> list = new ArrayList<NewsDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Content news = (Content) iterator.next();
				NewsDTO dto = createDto(news);
				list.add(dto);
			}
		}
		return list;
	}

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isTopline() {
		return topline;
	}

	public void setTopline(boolean topline) {
		this.topline = topline;
	}

	public boolean isRecommender() {
		return recommender;
	}

	public void setRecommender(boolean recommender) {
		this.recommender = recommender;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
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

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}
