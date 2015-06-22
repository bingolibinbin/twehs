package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.NewsService;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.menu.TypeService;
//import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.Page;

public class NewsAction extends BaseAction {

	private Integer contentid;
	private String title;
	private String topline;
	private boolean toplline; // 为数据转换设置
	private String recommender;
	private boolean recommendder; // 为数据转换设置
	private Integer typeid;
	private String typename;
	private String source;
	private String author;
	private String content;
	private Integer order;
	private Date operatetime;
	private String display;
	private boolean displlay; // 为数据转换设置

	private NewsService newsService;

	/*
	 * 动态查找新闻
	 */
	public String findPageNews() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			newsService.findPageNews(page, title, typeid); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除新闻
	 */
	public String deleteNews() {
		try {
			// System.out.println("delete:"+contentid);
			boolean b = newsService.deleteNews(contentid);

			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该分类已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该分类已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 保存/修改新闻
	 */
	public String saveOrUpdateNews() {

		try {
			// boolean 类型转换处：
			// 这里需要改变上面topline的类型为Integer ,然后自定义一个Boolean类型插入下面的构造函数
			int toplineint = Integer.parseInt(this.getTopline());
			// 从表现层想下层传输数据，从String类型转换成boolean类型
			if (toplineint == 1) {
				toplline = true;

			} else {
				toplline = false;
			}

			int recommenderint = Integer.parseInt(this.getRecommender());
			if (recommenderint == 1) {
				recommendder = true;

			} else {
				recommendder = false;
			}

			int displayint = Integer.parseInt(this.getDisplay());
			if (displayint == 1) {
				displlay = true;
			} else {
				displlay = false;
			}
			// 这里dto里面的toplline， recommender,displlay均是有topline
			// 等由String类型转换成boolean类型
			NewsDTO dto = new NewsDTO(contentid, toplline, recommendder,
					typeid, typename, source, author, content, order,
					operatetime, displlay, title);
			newsService.saveOrUpdateNews(dto);
			if (contentid == null) {
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

	public String findTypeType() {
		try {
			this.outListString(newsService.findTypeType());
			// 因为查询分类涉及到不同的menuid，所以讲查询分类方法集成到各个栏目自己的业务逻辑
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public Integer getContentid() {
		return contentid;
	}

	public String getTitle() {
		return title;
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

	public NewsService getNewsService() {
		return newsService;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public String getTopline() {
		return topline;
	}

	public String getRecommender() {
		return recommender;
	}

	public String getDisplay() {
		return display;
	}

	public void setTopline(String topline) {
		this.topline = topline;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
