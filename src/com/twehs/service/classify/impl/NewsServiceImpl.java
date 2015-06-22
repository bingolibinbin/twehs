package com.twehs.service.classify.impl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.twehs.dao.content.ContentDAO;
import com.twehs.dao.power.TypeDAO;
import com.twehs.pojo.Content;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Type;
import com.twehs.service.classify.NewsService;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.utils.pubutil.ComboData;
import com.twehs.utils.pubutil.Page;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.menu.dto.TypeDTO;

public class NewsServiceImpl implements NewsService {

	private ContentDAO newsDAO;
	private TypeDAO typeDAO;

	/*
	 * 动态查询
	 */
	public void findPageNews(Page page, String title, Integer typeid)
			throws SQLException {

		if (typeid != null || (title != null && title.length() != 0)) // 约束显示的情况
		{

			List<Content> listNews = newsDAO.selectByPaper(page.getStart(),
					page.getLimit(), title, typeid);
			@SuppressWarnings("rawtypes")
			List<NewsDTO> dtoList = NewsDTO.createDtos(listNews);
			int total = newsDAO.countAll();
			// 这里countAll是自己改写的，本身不提供这个函数
			page.setTotal(total);
			page.setRoot(dtoList);

		} else// 全部新闻显示的情况；
		{
			// 如果是全部显示的情况则显示全部新闻的内容；即menuid=20的所有content输出显示；
			int total = 0;
			List<Type> typeList = typeDAO.listAll(20); // 显示新闻的所有分类
			// 通过所有的typeid在content里面找出所有的contentid;
			List<Content> dtoListAll = new ArrayList<Content>();
			// 作为总newscontent为后面page输出做准备；

			for (Type type : typeList) {
				List<Content> newslist = newsDAO.selectByPaper(page.getStart(),
						page.getLimit(), title, type.getTypeid());
				total = total + newsDAO.countByTypeid(type.getTypeid()); // 求取pagesize
				if (newslist.size() != 0) {
					for (Content llist : newslist) {
						dtoListAll.add(llist);
						// 添加所有是新闻的content;
					}
				}
			}

			@SuppressWarnings("rawtypes")
			List<NewsDTO> dtoList = NewsDTO.createDtos(dtoListAll);
			page.setTotal(total);
			page.setRoot(dtoList);
		}
	}

	/*
	 * 保存和更新
	 */
	public boolean saveOrUpdateNews(NewsDTO dto) throws SQLException {
		Content news1 = new Content();
		if (dto.getContentid() != null) {
			news1 = (Content) newsDAO.selectByPrimaryKey(dto.getContentid());
			if (news1 != null) {
				// 更新新闻
				ContentOperateTime news3 = new ContentOperateTime();
				news3.setContentid(dto.getContentid());
				news3.setTitle(dto.getTitle());
				news3.setTopline(dto.isTopline());
				news3.setRecommender(dto.isRecommender());
				news3.setTypeid(dto.getTypeid());
				news3.setTypename(dto.getTypename());
				news3.setSource(dto.getSource());
				news3.setAuthor(dto.getAuthor());
				news3.setContent(dto.getContent());
				news3.setOrder(dto.getOrder());
				news3.setOperatetime(dto.getOperatetime());
				news3.setDisplay(dto.isDisplay());
				newsDAO.updateByPrimaryKeySelective(news3);
				return true;
			}
		} else {
			// 添加新闻
			ContentOperateTime news2 = new ContentOperateTime();
			news2.setContentid(dto.getContentid());
			news2.setTitle(dto.getTitle());
			news2.setTopline(dto.isTopline());
			news2.setRecommender(dto.isRecommender());
			news2.setTypeid(dto.getTypeid());
			news2.setTypename(dto.getTypename());
			news2.setSource(dto.getSource());
			news2.setAuthor(dto.getAuthor());
			news2.setContent(dto.getContent());
			news2.setOrder(dto.getOrder());
			news2.setOperatetime(dto.getOperatetime());
			news2.setDisplay(dto.isDisplay());
			newsDAO.insertwithid(news2);
			return true;
		}
		return false;
	}

	/*
	 * 删除新闻
	 */
	public boolean deleteNews(Integer contentid) {
		try {

			newsDAO.deleteByPrimaryKey(contentid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 查询所有分类
	 */
	public List findTypeType() throws SQLException {
		List list = new ArrayList();
		@SuppressWarnings("unchecked")
		List<Type> typeList = typeDAO.listAll(20);
		// 这里20 表示menuid=20,即查询所有栏目是新闻下面的分类
		for (Type type : typeList) {
			ComboData dto = new ComboData();
			dto.setValue(type.getTypeid().toString());
			dto.setText(type.getTypename());
			list.add(dto);
		}
		return list;
	}

	public ContentDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(ContentDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
}
