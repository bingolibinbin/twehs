package com.twehs.service.menu;

import java.sql.SQLException;

import java.util.List;

import com.twehs.service.menu.dto.MenuDTO;
import com.twehs.utils.pubutil.Page;

public interface MenuService {

	public void findPageMenu(Page page) throws SQLException;

	public boolean saveOrUpdateMenu(MenuDTO dto) throws SQLException;

	public boolean deleteMenu(Integer menuid);

	public List findMenuType(Integer menutype) throws SQLException;

}
