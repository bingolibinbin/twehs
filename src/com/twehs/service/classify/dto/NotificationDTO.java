package com.twehs.service.classify.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.twehs.dao.content.NodificationDAO;
import com.twehs.pojo.Content;
import com.twehs.pojo.Nodification;

public class NotificationDTO {

	private Integer notificationid;

	private String notification;
	private Date operatetime;
	private boolean display;
	private NodificationDAO notificationDAO;

	public NotificationDTO() {
		super();
	}

	public NotificationDTO(Integer notificationid, String notification,
			Date operatetime, boolean display) {
		super();
		this.notificationid = notificationid;
		this.notification = notification;
		this.operatetime = operatetime;
		this.display = display;

	}

	public static NotificationDTO createDto(Nodification pojo) {
		NotificationDTO dto = null;
		if (pojo != null) {
			dto = new NotificationDTO(pojo.getNotificationid(),
					pojo.getNotification(), pojo.getOperatetime(),
					pojo.getDisplay());

		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<NotificationDTO> list = new ArrayList<NotificationDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Nodification notify = (Nodification) iterator.next();
				NotificationDTO dto = createDto(notify);
				list.add(dto);
			}
		}
		return list;
	}

	public Integer getNotificationid() {
		return notificationid;
	}

	public String getNotification() {
		return notification;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public boolean isDisplay() {
		return display;
	}

	public NodificationDAO getNotificationDAO() {
		return notificationDAO;
	}

	public void setNotificationid(Integer notificationid) {
		this.notificationid = notificationid;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public void setNotificationDAO(NodificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

}
