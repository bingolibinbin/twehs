package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.NotificationService;
import com.twehs.service.classify.dto.NotificationDTO;
import com.twehs.utils.pubutil.Page;

public class NotificationAction extends BaseAction {

	private Integer notificationid;
	private String notification;
	private Date operatetime;
	private boolean displlay;
	private String display;
	private String notificationids;
	private NotificationService notificationService;

	/*
	 * 分页查询公告
	 */
	public String findPageNotifications() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			notificationService.findPageNotifications(page, notification); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除公告
	 */
	public String deleteNotifications() {
		try {
			String[] result = notificationids.split(",");
			if (result.length > 1) {
				this.outString("{success:false,error:'不能同时删除多个评论'}");
			}
			int notificationid = Integer.valueOf(notificationids);
			// 注意这样写有风险，注意规避，就是如果误操作同时选中多个来删除将导致删除其他评论
			boolean b = notificationService.deleteNotifications(notificationid);
			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该评论已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该评论已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 
	 * 更新和加入公告
	 */
	public String saveOrUpdateNotifications() {
		try {

			int displayint = Integer.parseInt(this.getDisplay());
			if (displayint == 1) {
				displlay = true;
			} else {
				displlay = false;
			}

			NotificationDTO dto = new NotificationDTO(notificationid,
					notification, operatetime, displlay);

			notificationService.saveOrUpdateNotifications(dto);
			if (notificationid == null) {
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

	public Integer getNotificationid() {
		return notificationid;
	}

	public String getNotification() {
		return notification;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public String getDisplay() {
		return display;
	}

	public NotificationService getNotificationService() {
		return notificationService;
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

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public String getNotificationids() {
		return notificationids;
	}

	public void setNotificationids(String notificationids) {
		this.notificationids = notificationids;
	}

}
