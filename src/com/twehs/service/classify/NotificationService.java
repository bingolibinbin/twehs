package com.twehs.service.classify;

import java.sql.SQLException;

import com.twehs.service.classify.dto.NotificationDTO;
import com.twehs.utils.pubutil.Page;

public interface NotificationService {

	/*
	 * findPageMessages deleteNotifications saveOrUpdateNotifications
	 */

	public void findPageNotifications(Page page, String notification)
			throws SQLException;

	public boolean saveOrUpdateNotifications(NotificationDTO dto)
			throws SQLException;

	public boolean deleteNotifications(Integer notificationid)
			throws SQLException;

}
