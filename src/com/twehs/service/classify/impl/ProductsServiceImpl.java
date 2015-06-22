package com.twehs.service.classify.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twehs.dao.content.ContentDAO;
import com.twehs.dao.power.TypeDAO;
import com.twehs.pojo.Content;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Type;
//import com.twehs.service.classify.NewsService;
import com.twehs.service.classify.ProductsService;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.classify.dto.ProductsDTO;
import com.twehs.utils.pubutil.Page;
import com.twehs.utils.pubutil.ComboData;

public class ProductsServiceImpl implements ProductsService {

	private ContentDAO productsDAO;
	private TypeDAO typeDAO;

	/*
	 * 分页查询产品
	 */
	public void findPageProducts(Page page, String title, Integer typeid)
			throws SQLException {

		if (typeid != null || (title != null && title.length() != 0))
		// 约束显示的情况
		{

			List<Content> listNews = productsDAO.selectByPaper(page.getStart(),
					page.getLimit(), title, typeid);
			
			System.out.println("Service层"+listNews.get(0));
			
			
			@SuppressWarnings("rawtypes")
			List<NewsDTO> dtoList = NewsDTO.createDtos(listNews);
			int total = productsDAO.countAll();
			// 这里countAll是自己改写的，本身不提供这个函数
			page.setTotal(total);
			page.setRoot(dtoList);

		} else// 全部新闻显示的情况；
		{
			// 如果是全部显示的情况则显示全部新闻的内容；即menuid=20的所有content输出显示；
			int total = 0;
			List<Type> typeList = typeDAO.listAllPro(301010); // 显示新闻的所有分类
			// 通过所有的typeid在content里面找出所有的contentid;
			List<Content> dtoListAll = new ArrayList<Content>();
			// 作为总newscontent为后面page输出做准备；
			for (Type type : typeList) {
				List<Content> newslist = productsDAO.selectByPaper(
						page.getStart(), page.getLimit(), title,
						type.getTypeid());
				total = total + productsDAO.countByTypeid(type.getTypeid()); // 求取pagesize
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

	// 这里需要加参数；

	/*
	 * 保存和更新产品
	 */
	public boolean saveOrUpdateProducts(ProductsDTO dto) throws SQLException {
		Content news1 = new Content();
		if (dto.getContentid() != null) {
			news1 = (Content) productsDAO.selectByPrimaryKey(dto.getContentid());
			if (news1.getContentid() != null) {
				// 更新新闻
				ContentOperateTime products3 = new ContentOperateTime();
				products3.setContentid(dto.getContentid());
				products3.setTypeid(dto.getTypeid());
				products3.setTypename(dto.getTypename());
			   
				products3.setTitle(dto.getTitle());
				products3.setTopline(dto.getTopline());
				products3.setRecommender(dto.getRecommender());
				products3.setOperatetime(dto.getOperatetime());
				products3.setDisplay(dto.getDisplay());
				products3.setSmallpicaddress(dto.getSmallpicaddress());
				products3.setSmallpicname(dto.getSmallpicname());
				products3.setSource(dto.getSource());
				products3.setSpecification(dto.getSpecification());
				products3.setPrice(dto.getPrice());
				products3.setContent(dto.getContent());
				products3.setOrder(dto.getOrder());
				productsDAO.updateByPrimaryKeySelective(products3);
				
				return true;
			}
		} else {
			// 添加新闻
			ContentOperateTime products2 = new ContentOperateTime();
			products2.setContentid(dto.getContentid());
			products2.setTypeid(dto.getTypeid());
			products2.setTypename(dto.getTypename());
			products2.setTitle(dto.getTitle());
			products2.setTopline(dto.getTopline());
			products2.setRecommender(dto.getRecommender());
			products2.setOperatetime(dto.getOperatetime());
			products2.setDisplay(dto.getDisplay());
			products2.setSmallpicaddress(dto.getSmallpicaddress());
			products2.setSmallpicname(dto.getSmallpicname());
			products2.setSource(dto.getSource());
			products2.setSpecification(dto.getSpecification());
			products2.setPrice(dto.getPrice());
			products2.setContent(dto.getContent());
			products2.setOrder(dto.getOrder());
			productsDAO.insertwithid(products2);
			return true;
		}
		return false;

	}

	/*
	 * 删除产品
	 */
	public boolean deleteProducts(Integer contentid) throws SQLException {
		try {

			productsDAO.deleteByPrimaryKey(contentid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 寻找分类
	 */
	public List findTypeType() throws SQLException {
		List list = new ArrayList();
		@SuppressWarnings("unchecked")
		// List<Type> typeList = typeDAO.listAll(menuid);
		List<Type> typeList = typeDAO.listAllPro(301010);
		// System.out.println("typeid"+typeList.get(0)); //数据未到这里来
		for (Type type : typeList) {
			ComboData dto = new ComboData();
			dto.setValue(type.getTypeid().toString());
			dto.setText(type.getTypename());
			list.add(dto);
		}
		return list;
	}

	
	
	public ContentDAO getProductsDAO() {
		return productsDAO;
	}

	public void setProductsDAO(ContentDAO productsDAO) {
		this.productsDAO = productsDAO;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

}
