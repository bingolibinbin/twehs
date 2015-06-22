package com.twehs.service.menu.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.twehs.pojo.Menu;
import com.twehs.service.menu.MenuService;
import com.twehs.pojo.example.MenuExample;
import com.twehs.pojo.example.MenuExample.Criteria;
import com.twehs.dao.power.MenuDAO;
//import com.twehs.dao.power.impl.MenuDAOImpl;
import com.twehs.service.menu.dto.MenuDTO;
//import com.twehs.service.power.dto.UserDTO;
import com.twehs.utils.pubutil.Page;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;

	public MenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	/*
	 * 
	 * 分页查询
	 */
	public void findPageMenu(Page page) throws SQLException {
		// TODO Auto-generated method stub
		List<Menu> listMenu = menuDAO.selectByPaper(page.getStart(),
				page.getLimit());
		@SuppressWarnings("rawtypes")
		List dtoList = MenuDTO.createDtos(listMenu);
		int total = menuDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);
	}

	/*
	 * 
	 * 保存和更新
	 */
	public boolean saveOrUpdateMenu(MenuDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		Menu menu1 = new Menu();
		if (dto.getMenuid() != null) {
			menu1 = (Menu) menuDAO.selectByPrimaryKey(dto.getMenuid());
			if (menu1 == null) {
				Menu menu2 = new Menu();
				menu2.setMenuid(dto.getMenuid());
				menu2.setMenuname(dto.getMenuname());
				menu2.setPid(dto.getPid());
				menu2.setMenuurl(dto.getMenuurl());
				menu2.setMenutype(dto.getMenutype());
				menu2.setOrdernum(dto.getOrdernum());
				menu2.setIcon(dto.getIcon());
				menuDAO.insertwithid(menu2);
				return true;
			} else {
				menu1.setMenuname(dto.getMenuname());
				menu1.setPid(dto.getPid());
				menu1.setMenuurl(dto.getMenuurl());
				menu1.setMenutype(dto.getMenutype());
				menu1.setOrdernum(dto.getOrdernum());
				menu1.setIcon(dto.getIcon());
				System.out.println("menu1.menuname:" + menu1.getMenuname());
				menuDAO.updateByPrimaryKeySelective(menu1); // 数据库更新
				return true;
			}
		}
		return false;
	}

	/*
	 * 
	 * 删除Menu
	 */
	public boolean deleteMenu(Integer menuid) {
		try {
			menuDAO.deleteByPrimaryKey(menuid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 查询Menutype
	 */
	public List<Menu> findMenuType(Integer menutype) throws SQLException {
		// TODO Auto-generated method stub
		List<Menu> listMenutype;
		listMenutype = menuDAO.selectByMenuType(menutype);
		return listMenutype;
		/*
		 * private List getChildrens(List funcs, Integer menuid) { List
		 * resultList = new ArrayList(); Menu func = null; for (Object obj :
		 * funcs) { func = (Menu) obj; if (func.getPid().equals(menuid))
		 * {//父节点id resultList.add(func); } } menuDAO.selectByMenuType() return
		 * resultList; }
		 */
	}
}
