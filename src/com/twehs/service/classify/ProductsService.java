package com.twehs.service.classify;

import java.sql.SQLException;
import java.util.List;

//import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.classify.dto.ProductsDTO;
import com.twehs.utils.pubutil.Page;

public interface ProductsService {

	public void findPageProducts(Page page, String title, Integer typeid)
			throws SQLException;

	public boolean saveOrUpdateProducts(ProductsDTO dto) throws SQLException;

	public boolean deleteProducts(Integer contentid) throws SQLException;

	public List findTypeType() throws SQLException;

}
