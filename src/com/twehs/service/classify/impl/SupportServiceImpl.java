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
import com.twehs.service.classify.SupportService;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.classify.dto.SupportDTO;
import com.twehs.utils.pubutil.ComboData;
import com.twehs.utils.pubutil.Page;
import com.twehs.service.menu.dto.TypeDTO;

public class SupportServiceImpl implements SupportService {

	private ContentDAO supportsDAO;
	private TypeDAO typeDAO;

	/*
	 * 动态查询
	 */
	public void findPageSupports(Page page, String title, Integer typeid)
			throws SQLException {

		if (typeid != null || (title != null && title.length() != 0)) // 约束显示的情况
		{

			List<Content> listNews = supportsDAO.selectByPaper(page.getStart(),
					page.getLimit(), title, typeid);
			@SuppressWarnings("rawtypes")
			List<NewsDTO> dtoList = SupportDTO.createDtos(listNews);
			int total = supportsDAO.countAll();
			// 这里countAll是自己改写的，本身不提供这个函数
			page.setTotal(total);
			page.setRoot(dtoList);

		} else// 全部新闻显示的情况；
		{
			// 如果是全部显示的情况则显示全部新闻的内容；即menuid=20的所有content输出显示；
			int total = 0;
			List<Type> typeList = typeDAO.listAll(60); // 显示支持的所有分类
			// 通过所有的typeid在content里面找出所有的contentid;
			List<Content> dtoListAll = new ArrayList<Content>();
			// 作为总newscontent为后面page输出做准备；

			for (Type type : typeList) {
				List<Content> newslist = supportsDAO.selectByPaper(
						page.getStart(), page.getLimit(), title,
						type.getTypeid());
				total = total + supportsDAO.countByTypeid(type.getTypeid()); // 求取pagesize
				if (newslist.size() != 0) {
					for (Content llist : newslist) {
						dtoListAll.add(llist);
						// 添加所有是新闻的content;
					}
				}
			}

			@SuppressWarnings("rawtypes")
			List<SupportDTO> dtoList = SupportDTO.createDtos(dtoListAll);
			page.setTotal(total);
			page.setRoot(dtoList);
		}
	}

	/*
	 * 保存和更新
	 */
	public boolean saveOrUpdateSupports(SupportDTO dto) throws SQLException {
		Content sup1 = new Content();
		if (dto.getContentid() != null) {
			sup1 = (Content) supportsDAO.selectByPrimaryKey(dto.getContentid());
			if (sup1 != null) {
				// 更新新闻
				ContentOperateTime sup3 = new ContentOperateTime();
				sup3.setContentid(dto.getContentid());
				sup3.setTypeid(dto.getTypeid());
				sup3.setTypename(dto.getTypename());
				sup3.setTitle(dto.getTitle());
				sup3.setOperatetime(dto.getOperatetime());
				sup3.setDisplay(dto.isDisplay());
				sup3.setContent(dto.getContent());
				supportsDAO.updateByPrimaryKeySelective(sup3);
				return true;
			}
		} else {
			// 添加新闻
			ContentOperateTime sup2 = new ContentOperateTime();
			sup2.setContentid(dto.getContentid());
			sup2.setTypeid(dto.getTypeid());
			sup2.setTypename(dto.getTypename());
			sup2.setTitle(dto.getTitle());
			sup2.setOperatetime(dto.getOperatetime());
			sup2.setDisplay(dto.isDisplay());
			sup2.setContent(dto.getContent());
			supportsDAO.insertwithid(sup2);
			return true;
		}
		return false;
	}

	/*
	 * 删除新闻
	 */
	public boolean deleteSupports(Integer contentid) {
		try {

			supportsDAO.deleteByPrimaryKey(contentid);
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
		List<Type> typeList = typeDAO.listAll(60);
		// 这里20 表示menuid=20,即查询所有栏目是新闻下面的分类
		for (Type type : typeList) {
			ComboData dto = new ComboData();
			dto.setValue(type.getTypeid().toString());
			dto.setText(type.getTypename());
			list.add(dto);
		}
		return list;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	public ContentDAO getSupportsDAO() {
		return supportsDAO;
	}

	public void setSupportsDAO(ContentDAO supportsDAO) {
		this.supportsDAO = supportsDAO;
	}

}
