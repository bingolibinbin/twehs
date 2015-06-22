package com.twehs.service.classify;

import java.sql.SQLException;
import java.util.List;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.utils.pubutil.Page;

public interface NewsService {

	public void findPageNews(Page page, String title, Integer typeid)
			throws SQLException;

	// 这里需要加参数；

	public boolean saveOrUpdateNews(NewsDTO dto) throws SQLException;

	public boolean deleteNews(Integer contentid) throws SQLException;

	public List findTypeType() throws SQLException;

}
