package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.MessageService;
import com.twehs.service.classify.dto.MessageDTO;
import com.twehs.service.company.dto.CompanyDTO;
import com.twehs.utils.pubutil.Page;

public class MessageAction extends BaseAction {

	private Integer messageid;
	private String username;
	private String phoneno;
	private String address;
	private String messagescontent;
	private Date operatetime;

	private MessageService messageService;

	/*
	 * 分页动态查询
	 */
	public String findPageMessages() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			messageService.findPageMessages(page, phoneno); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除操作
	 */
	public String deleteMessages() {
		try {
			// System.out.println("delete:"+contentid);
			boolean b = messageService.deleteMessages(messageid);

			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该留言已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该留言已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 
	 * 更新和加入留言
	 */
	public String saveOrUpdateMessages() {
		try {

			MessageDTO dto = new MessageDTO(messageid, username, phoneno,
					address, operatetime, messagescontent);

			messageService.saveOrUpdateMessages(dto);
			if (messageid == null) {
				this.outString("{success:true,message:'保存成功!'}");
			} else {
				this.outString("{success:true,message:'修改成功!'}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public Integer getMessageid() {
		return messageid;
	}

	public String getUsername() {
		return username;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public String getAddress() {
		return address;
	}

	public String getMessagescontent() {
		return messagescontent;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMessagescontent(String messagescontent) {
		this.messagescontent = messagescontent;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
