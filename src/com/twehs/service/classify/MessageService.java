package com.twehs.service.classify;

import java.sql.SQLException;

import com.twehs.service.classify.dto.MessageDTO;
import com.twehs.utils.pubutil.Page;

public interface MessageService {

	public void findPageMessages(Page page, String phoneno) throws SQLException;

	public boolean saveOrUpdateMessages(MessageDTO dto) throws SQLException;

	public boolean deleteMessages(Integer contentid) throws SQLException;

}
