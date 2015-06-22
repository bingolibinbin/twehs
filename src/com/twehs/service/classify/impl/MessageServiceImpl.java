package com.twehs.service.classify.impl;

import java.sql.SQLException;

import java.util.List;

import com.twehs.dao.content.MessageDAO;
import com.twehs.pojo.Content;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Message;
import com.twehs.service.classify.MessageService;
import com.twehs.service.classify.dto.MessageDTO;
import com.twehs.service.classify.dto.ProjectsDTO;
import com.twehs.utils.pubutil.Page;

public class MessageServiceImpl implements MessageService {

	private MessageDAO messageDAO;

	/*
	 * 分页查询
	 */
	public void findPageMessages(Page page, String phoneno) throws SQLException {

		List<Message> listMessages = messageDAO.selectByPaper(page.getStart(),
				page.getLimit(), phoneno);
		@SuppressWarnings("rawtypes")
		List<MessageDTO> dtoList = MessageDTO.createDtos(listMessages);
		int total = messageDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);
	}

	/*
	 * 删除操作
	 */
	public boolean deleteMessages(Integer messageid) throws SQLException {
		try {
			messageDAO.deleteByPrimaryKey(messageid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * 更新保存工程
	 */
	public boolean saveOrUpdateMessages(MessageDTO dto) throws SQLException {
		Message message1 = new Message();
		if (dto.getMessageid() != null) {
			message1 = (Message) messageDAO.selectByPrimaryKey(dto
					.getMessageid());
			if (message1 != null) {
				// 更新新闻
				Message message3 = new Message();
				message3.setMessageid(dto.getMessageid());
				message3.setUsername(dto.getUsername());
				message3.setPhoneno(dto.getPhoneno());
				message3.setAddress(dto.getAddress());
				message3.setMessagecontent(dto.getMessagescontent());
				message3.setOperatetime(dto.getOperatetime());

				messageDAO.updateByPrimaryKeySelective(message3);
				return true;
			}
		} else {
			// 添加新闻
			Message message2 = new Message();
			message2.setMessageid(dto.getMessageid());
			message2.setUsername(dto.getUsername());
			message2.setPhoneno(dto.getPhoneno());
			message2.setAddress(dto.getAddress());
			message2.setMessagecontent(dto.getMessagescontent());
			message2.setOperatetime(dto.getOperatetime());

			messageDAO.insertwithid(message2);
			return true;
		}
		return false;

	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

}
