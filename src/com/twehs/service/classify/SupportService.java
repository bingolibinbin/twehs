package com.twehs.service.classify;

import java.sql.SQLException;
import java.util.List;

import com.twehs.service.classify.dto.SupportDTO;
import com.twehs.utils.pubutil.Page;

public interface SupportService {

	public void findPageSupports(Page page, String title, Integer typeid)
			throws SQLException;

	// 这里需要加参数；
	public boolean saveOrUpdateSupports(SupportDTO dto) throws SQLException;

	public boolean deleteSupports(Integer contentid) throws SQLException;

	public List findTypeType() throws SQLException;

}
