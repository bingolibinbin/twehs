package com.twehs.service.menu.impl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.twehs.dao.power.TypeDAO;
//import com.twehs.pojo.Menu;
import com.twehs.pojo.Type;
//import com.twehs.service.menu.MenuService;
import com.twehs.service.menu.TypeService;
//import com.twehs.service.menu.dto.MenuDTO;
import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.ComboData;
import com.twehs.utils.pubutil.Page;

public class TypeServiceImpl implements TypeService {

	private TypeDAO typeDAO;

	/*
	 * 分页查询Type
	 */
	public void findPageTtype(Page page) throws SQLException {
		// TODO Auto-generated method stub
		List<Type> listType = typeDAO.selectByPaper(page.getStart(),
				page.getLimit());
		@SuppressWarnings("rawtypes")
		List<TypeDTO> dtoList = TypeDTO.createDtos(listType);
		int total = typeDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);
	}

	/*
	 * 保存和更新
	 */
	public boolean saveOrUpdateTtype(TypeDTO dto) throws SQLException {

		Type type1 = new Type();
		if (dto.getTypeid() != null) {
			type1 = (Type) typeDAO.selectByPrimaryKey(dto.getTypeid());
			if (type1 != null) {
				type1.setMenuid(dto.getMenuid());
				type1.setTypename(dto.getTypename());
				type1.setBz(dto.getBz());
				typeDAO.updateByPrimaryKeySelective(type1); // 数据库更新
				return true;
			}
		} else {
			Type type2 = new Type();
			type2.setMenuid(dto.getMenuid());
			type2.setTypename(dto.getTypename());
			type2.setBz(dto.getBz());
			typeDAO.insertwithid(type2);
			return true;
		}
		return false;
	}

	public boolean deleteTtype(Integer typeid) throws SQLException {
		try {
			typeDAO.deleteByPrimaryKey(typeid);
			System.out.println("删除操作");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List findTtypeType(Integer menuid) throws SQLException {
		List list = new ArrayList();
		@SuppressWarnings("unchecked")
		// List<Type> typeList = typeDAO.listAll(menuid);
		List<Type> typeList = typeDAO.listAll(menuid);
		for (Type type : typeList) {
			ComboData dto = new ComboData();
			dto.setValue(type.getTypeid().toString());
			dto.setText(type.getTypename());
			list.add(dto);
		}
		return list;
	}

	/*
	 * public List findDepartmentType() { // TODO Auto-generated method stub
	 * 
	 * List list = new ArrayList(); List<Department> departmentList =
	 * baseDao.listAll("Department"); for (Department department :
	 * departmentList) { ComboData dto = new ComboData();
	 * dto.setValue(department.getDepartmentid().toString());
	 * dto.setText(department.getDepartmentname()); list.add(dto); } return
	 * list; }
	 */

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
}
