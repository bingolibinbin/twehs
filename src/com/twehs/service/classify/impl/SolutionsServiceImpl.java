package com.twehs.service.classify.impl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.twehs.dao.content.ContentDAO;
import com.twehs.dao.power.TypeDAO;
import com.twehs.pojo.Content;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Type;

import com.twehs.service.classify.ProjectsService;
import com.twehs.service.classify.SolutionsService;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.classify.dto.ProjectsDTO;
import com.twehs.service.classify.dto.SolutionsDTO;
import com.twehs.utils.pubutil.Page;
import com.twehs.utils.pubutil.ComboData;

public class SolutionsServiceImpl implements SolutionsService {

	private ContentDAO solutionsDAO;
	private TypeDAO typeDAO;

	/*
	 * 
	 * 分页查询解决方案
	 */
	public void findPageSolutions(Page page, String title, Integer typeid)
			throws SQLException {
		if (typeid != null || (title != null && title.length() != 0)) // 约束显示的情况
		{

			List<Content> listNews = solutionsDAO.selectByPaper(
					page.getStart(), page.getLimit(), title, typeid);
			@SuppressWarnings("rawtypes")
			List<NewsDTO> dtoList = NewsDTO.createDtos(listNews);
			int total = solutionsDAO.countAll();
			// 这里countAll是自己改写的，本身不提供这个函数
			page.setTotal(total);
			page.setRoot(dtoList);

		} else// 全部新闻显示的情况；
		{
			// 如果是全部显示的情况则显示全部新闻的内容；即menuid=20的所有content输出显示；
			int total = 0;
			List<Type> typeList = typeDAO.listAll(50); // 显示新闻的所有分类
			// 通过所有的typeid在content里面找出所有的contentid;
			List<Content> dtoListAll = new ArrayList<Content>();
			// 作为总newscontent为后面page输出做准备；
			for (Type type : typeList) {
				List<Content> newslist = solutionsDAO.selectByPaper(
						page.getStart(), page.getLimit(), title,
						type.getTypeid());
				total = total + solutionsDAO.countByTypeid(type.getTypeid()); // 求取pagesize
				if (newslist.size() != 0) {
					for (Content llist : newslist) {
						dtoListAll.add(llist); // 添加所有是新闻的content;
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
	 * 更新和保存解决方案
	 */
	// 这里需要加参数；
	public boolean saveOrUpdateSolutions(SolutionsDTO dto) throws SQLException {
		Content news1 = new Content();
		if (dto.getContentid() != null) {
			news1 = (Content) solutionsDAO.selectByPrimaryKey(dto
					.getContentid());
			if (news1 != null) {
				// 更新解决方案
				ContentOperateTime products3 = new ContentOperateTime();
				products3.setContentid(dto.getContentid());
				products3.setTypeid(dto.getTypeid());
				products3.setTypename(dto.getTypename());
				products3.setTitle(dto.getTitle());
				products3.setOperatetime(dto.getOperatetime());
				products3.setDisplay(dto.isDisplay());
				products3.setSmallpicaddress(dto.getSmallpicaddress());
				products3.setSmallpicname(dto.getSmallpicname());
				products3.setContent(dto.getContent());

				solutionsDAO.updateByPrimaryKeySelective(products3);
				return true;
			}
		} else {
			// 添加解决方案
			ContentOperateTime products2 = new ContentOperateTime();
			products2.setContentid(dto.getContentid());
			products2.setTypeid(dto.getTypeid());
			products2.setTypename(dto.getTypename());
			products2.setTitle(dto.getTitle());
			products2.setOperatetime(dto.getOperatetime());
			products2.setDisplay(dto.isDisplay());
			products2.setSmallpicaddress(dto.getSmallpicaddress());
			products2.setSmallpicname(dto.getSmallpicname());
			products2.setContent(dto.getContent());

			solutionsDAO.insertwithid(products2);
			return true;
		}
		return false;

	}

	/*
	 * 删除解决方案
	 */
	public boolean deleteSolutions(Integer contentid) throws SQLException {
		try {

			solutionsDAO.deleteByPrimaryKey(contentid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * 查询分类
	 */
	public List findTypeType() throws SQLException {
		List list = new ArrayList();
		@SuppressWarnings("unchecked")
		// List<Type> typeList = typeDAO.listAll(menuid);
		Integer menuid = 20;
		List<Type> typeList = typeDAO.listAll(50);
		// System.out.println("typeid"+typeList.get(0)); //数据未到这里来
		for (Type type : typeList) {
			ComboData dto = new ComboData();
			dto.setValue(type.getTypeid().toString());
			dto.setText(type.getTypename());
			list.add(dto);
		}
		return list;
	}

	public ContentDAO getSolutionsDAO() {
		return solutionsDAO;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setSolutionsDAO(ContentDAO solutionsDAO) {
		this.solutionsDAO = solutionsDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

}
