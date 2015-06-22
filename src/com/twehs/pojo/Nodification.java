package com.twehs.pojo;

import java.util.Date;

public class Nodification {

	private Integer notificationid;

	private String notification;

	private Date operatetime;

	private Boolean display;

	public Integer getNotificationid() {
		return notificationid;
	}

	public void setNotificationid(Integer notificationid) {
		this.notificationid = notificationid;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}
}