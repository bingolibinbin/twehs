package com.twehs.service.classify.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.twehs.pojo.Content;
import com.twehs.pojo.Message;

public class MessageDTO {

	private Integer messageid;
	private String username;
	private String phoneno;
	private String address;
	private Date operatetime;
	private String messagescontent;

	public MessageDTO() {
		super();
	}

	public MessageDTO(Integer messageid, String username, String phoneno,
			String address, Date operatetime, String messagescontent) {
		super();
		this.messageid = messageid;
		this.username = username;
		this.phoneno = phoneno;
		this.address = address;
		this.operatetime = operatetime;
		this.messagescontent = messagescontent;

	}

	public static MessageDTO createDto(Message pojo) {
		MessageDTO dto = null;
		if (pojo != null) {
			dto = new MessageDTO(pojo.getMessageid(), pojo.getUsername(),
					pojo.getPhoneno(), pojo.getAddress(),
					pojo.getOperatetime(), pojo.getMessagecontent());

		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<MessageDTO> list = new ArrayList<MessageDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Message messages = (Message) iterator.next();
				MessageDTO dto = createDto(messages);
				list.add(dto);
			}
		}
		return list;
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

}
