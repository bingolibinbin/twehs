package com.twehs.service.classify;

import java.sql.SQLException;

import java.util.List;

import com.twehs.service.classify.dto.ProjectsDTO;
import com.twehs.service.classify.dto.SolutionsDTO;
//import com.twehs.service.classify.dto.ProjectsDTO;
import com.twehs.utils.pubutil.Page;

public interface SolutionsService {

	public void findPageSolutions(Page page, String title, Integer typeid)
			throws SQLException;

	// 这里需要加参数；
	public boolean saveOrUpdateSolutions(SolutionsDTO dto) throws SQLException;

	public boolean deleteSolutions(Integer contentid) throws SQLException;

	public List findTypeType() throws SQLException;

}
