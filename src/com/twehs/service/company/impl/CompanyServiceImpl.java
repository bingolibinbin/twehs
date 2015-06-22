package com.twehs.service.company.impl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.twehs.pojo.Company;
import com.twehs.pojo.Menu;
import com.twehs.service.company.CompanyService;
import com.twehs.pojo.example.CompanyExample;
import com.twehs.pojo.example.CompanyExample.Criteria;
import com.twehs.dao.company.CompanyDAO;
//import com.twehs.dao.power.impl.MenuDAOImpl;
import com.twehs.service.company.dto.CompanyDTO;
//import com.twehs.service.menu.dto.MenuDTO;
//import com.twehs.service.power.dto.UserDTO;
import com.twehs.utils.pubutil.Page;

public class CompanyServiceImpl implements CompanyService {

	private CompanyDAO companyDAO;

	/*
	 * 
	 * 分页查询
	 */
	public void findPageCompanys(Page page) throws SQLException {
		// TODO Auto-generated method stub
		List<Company> listCompany = companyDAO.selectByPaper(page.getStart(),
				page.getLimit());
		@SuppressWarnings("rawtypes")
		List dtoList = CompanyDTO.createDtos(listCompany);
		int total = companyDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);

	}

	/*
	 * 
	 * 保存和更新
	 */
	public boolean saveOrUpdateCompany(CompanyDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		Company company1 = new Company();
		if (dto.getCompanyid() != null) {
			company1 = (Company) companyDAO.selectByPrimaryKey(dto
					.getCompanyid());
			if (company1 != null) {
				// 更新操作；
				company1.setCompanyname(dto.getCompanyname());
				company1.setProfession(dto.getProfession());
				company1.setArea(dto.getArea());
				company1.setWebsite(dto.getWebsite());
				company1.setConnector(dto.getConnector());
				company1.setPhoneno(dto.getPhoneno());
				company1.setMobileno(dto.getMobileno());
				company1.setFax(dto.getFax());
				company1.setPostcode(dto.getPostcode());
				company1.setEmail(dto.getEmail());
				company1.setContent(dto.getContent());
				companyDAO.updateByPrimaryKeySelective(company1); // 数据库更新

				return true;
			}
		} else {

			// 插入操作
			Company company2 = new Company();
			// company2.setCompanyid(dto.getCompanyid());
			company2.setCompanyname(dto.getCompanyname());
			System.out.println("service:companyname" + dto.getCompanyname());
			company2.setProfession(dto.getProfession());
			company2.setArea(dto.getArea());
			company2.setWebsite(dto.getWebsite());
			company2.setConnector(dto.getConnector());
			company2.setPhoneno(dto.getPhoneno());
			company2.setMobileno(dto.getMobileno());
			company2.setFax(dto.getFax());
			company2.setPostcode(dto.getPostcode());
			company2.setEmail(dto.getEmail());
			company2.setContent(dto.getContent());

			companyDAO.insertwithid(company2);
			return true;
		}

		return false;

	}

	/*
	 * 
	 * 删除操作
	 */
	public boolean deleteCompanys(Integer companyid) {
		try {
			companyDAO.deleteByPrimaryKey(companyid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

}
