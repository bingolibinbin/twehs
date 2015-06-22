package com.twehs.service.company;

import java.sql.SQLException;

import com.twehs.service.company.dto.CompanyDTO;
//import com.twehs.service.menu.dto.MenuDTO;
import com.twehs.utils.pubutil.Page;

public interface CompanyService {

	public void findPageCompanys(Page page) throws SQLException;

	public boolean saveOrUpdateCompany(CompanyDTO dto) throws SQLException;

	public boolean deleteCompanys(Integer companyid);

}
