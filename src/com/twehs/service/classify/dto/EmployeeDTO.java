package com.twehs.service.classify.dto;

import java.util.Date;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.twehs.pojo.Employee;
import com.twehs.pojo.Message;

public class EmployeeDTO {


	private Integer employeeid;
	private String title;
	private String content;
	private Date operatetime;
	private boolean display;
	
	public EmployeeDTO() {
		super();
	}
	
	
	
	public EmployeeDTO(Integer employeeid, String title, String content,
			Date operatetime, boolean display) {
		super();
		this.employeeid = employeeid;
		this.title = title;
		this.content = content;
		this.operatetime = operatetime;
		this.display = display;
	}

	
	
	public static EmployeeDTO createDto(Employee pojo) {
		EmployeeDTO dto = null;
		if (pojo != null) {
			dto = new EmployeeDTO(pojo.getEmployeeid(),pojo.getTitle(),pojo.getContent(),pojo.getOperatetime(),pojo.getDisplay());

		}
		return dto;
	}
	
	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Employee employee = (Employee) iterator.next();
				EmployeeDTO dto = createDto(employee);
				list.add(dto);
			}
		}
		return list;
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

	


	public void setDisplay(boolean display) {
		this.display = display;
	}



	public boolean isDisplay() {
		return display;
	}

	
	
	
	
	
	
}
