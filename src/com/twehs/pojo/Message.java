package com.twehs.pojo;

import java.util.Date;

public class Message {

	private Integer messageid;

	
	private String username;


	private String phoneno;


	private String address;


	private Date operatetime;

	
	private String messagecontent;


	public Integer getMessageid() {
		return messageid;
	}


	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getOperatetime() {
		return operatetime;
	}


	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}


	public String getMessagecontent() {
		return messagecontent;
	}


	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
}