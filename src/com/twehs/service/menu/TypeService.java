package com.twehs.service.menu;

import java.sql.SQLException;
import java.util.List;

import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.Page;

public interface TypeService {

	public void findPageTtype(Page page) throws SQLException;

	public boolean saveOrUpdateTtype(TypeDTO dto) throws SQLException;

	public boolean deleteTtype(Integer typeid) throws SQLException;

	public List findTtypeType(Integer menuid) throws SQLException;
}
