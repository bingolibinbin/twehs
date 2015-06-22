package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.EmployeeService;
import com.twehs.service.classify.dto.EmployeeDTO;
import com.twehs.service.classify.dto.NotificationDTO;
import com.twehs.utils.pubutil.Page;

public class EmployeeAction extends BaseAction {

	private Integer employeeid;
	private String title;
	private String content;
	private Date operatetime;
	private boolean displlay;
	private String display;
	private String employeeids;

	private EmployeeService employeeService;

	/*
	 * 分页查询招聘
	 */
	public String findPageEmployee() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			employeeService.findPageEmployee(page, title); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除招聘
	 */
	public String deleteEmployee() {
		try {
			String[] result = employeeids.split(",");
			if (result.length > 1) {
				this.outString("{success:false,error:'不能同时删除多个评论'}");
			}
			int employeeid = Integer.valueOf(employeeids);
			// 注意这样写有风险，注意规避，就是如果误操作同时选中多个来删除将导致删除其他评论
			boolean b = employeeService.deleteEmployee(employeeid);
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
	 * 更新和加入招聘
	 */
	public String saveOrUpdateEmployee() {
		try {
			// 数据转换
			int displayint = Integer.parseInt(this.getDisplay());
			if (displayint == 1) {
				displlay = true;
			} else {
				displlay = false;
			}

			EmployeeDTO dto = new EmployeeDTO(employeeid, title, content,
					operatetime, displlay);

			employeeService.saveOrUpdateEmployee(dto);
			if (employeeid == null) {
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

	public Integer getEmployeeid() {
		return employeeid;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public String getDisplay() {
		return display;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getEmployeeids() {
		return employeeids;
	}

	public void setEmployeeids(String employeeids) {
		this.employeeids = employeeids;
	}

}
