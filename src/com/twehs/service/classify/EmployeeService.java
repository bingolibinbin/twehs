package com.twehs.service.classify;

import java.sql.SQLException;

import com.twehs.service.classify.dto.EmployeeDTO;
import com.twehs.utils.pubutil.Page;

public interface EmployeeService {

	
	public void findPageEmployee(Page page, String title) throws SQLException;

	public boolean saveOrUpdateEmployee(EmployeeDTO dto) throws SQLException;

	public boolean deleteEmployee(Integer contentid) throws SQLException;
}
