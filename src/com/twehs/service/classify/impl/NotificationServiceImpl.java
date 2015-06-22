package com.twehs.service.classify.impl;

import java.sql.SQLException;
import java.util.List;

import com.twehs.dao.content.NodificationDAO;
import com.twehs.pojo.Nodification;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.service.classify.NotificationService;
import com.twehs.service.classify.dto.NotificationDTO;
import com.twehs.utils.pubutil.Page;

public class NotificationServiceImpl implements NotificationService {

	private NodificationDAO notificationDAO;

	/*
	 * 
	 * 分页查询
	 */
	public void findPageNotifications(Page page, String notification)
			throws SQLException {

		List<Nodification> listNotifications = notificationDAO.selectByPaper(
				page.getStart(), page.getLimit(), notification);
		@SuppressWarnings("rawtypes")
		List<NotificationDTO> dtoList = NotificationDTO
				.createDtos(listNotifications);
		int total = notificationDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);

	}

	/*
	 * 保存和更新公告
	 */
	public boolean saveOrUpdateNotifications(NotificationDTO dto)
			throws SQLException {
		Nodification news1 = new Nodification();
		if (dto.getNotificationid() != null) {
			news1 = (Nodification) notificationDAO.selectByPrimaryKey(dto
					.getNotificationid());
			if (news1 != null) {
				// 更新新闻
				Nodification notif3 = new Nodification();
				notif3.setNotificationid(dto.getNotificationid());
				notif3.setNotification(dto.getNotification());
				notif3.setOperatetime(dto.getOperatetime());
				notif3.setDisplay(dto.isDisplay());

				notificationDAO.updateByPrimaryKeySelective(notif3);
				return true;
			}
		} else {
			Nodification notif2 = new Nodification();
			notif2.setNotificationid(dto.getNotificationid());
			notif2.setNotification(dto.getNotification());
			notif2.setOperatetime(dto.getOperatetime());
			notif2.setDisplay(dto.isDisplay());

			notificationDAO.insertwithid(notif2);
			return true;
		}
		return false;
	}

	/*
	 * 删除公告
	 */
	public boolean deleteNotifications(Integer notificationid)
			throws SQLException {
		try {
			// System.out.println("删除操作:"+contentid);
			notificationDAO.deleteByPrimaryKey(notificationid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public NodificationDAO getNotificationDAO() {
		return notificationDAO;
	}

	public void setNotificationDAO(NodificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}

}
