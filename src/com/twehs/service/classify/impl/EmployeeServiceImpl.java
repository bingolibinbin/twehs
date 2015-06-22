package com.twehs.service.classify.impl;

import java.sql.SQLException;

import com.twehs.dao.content.EmployeeDAO;
import com.twehs.service.classify.EmployeeService;
import com.twehs.service.classify.MessageService;
import com.twehs.service.classify.dto.EmployeeDTO;
import com.twehs.service.classify.dto.MessageDTO;
import com.twehs.utils.pubutil.Page;
import java.util.List;
import com.twehs.pojo.ContentOperateTime;
import com.twehs.pojo.Employee;
import com.twehs.pojo.Message;
import com.twehs.utils.pubutil.Page;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	/*
	 * 
	 * 查询招聘
	 * 
	 */
	public void findPageEmployee(Page page, String title) throws SQLException{
		List<Employee> listEmployee = employeeDAO.selectByPaper(page.getStart(),
				page.getLimit(), title);
		@SuppressWarnings("rawtypes")
		List<EmployeeDTO> dtoList = EmployeeDTO.createDtos(listEmployee);
		int total = employeeDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setTotal(total);
		page.setRoot(dtoList);
	}

	/*
	 * 保存更新招聘
	 * 
	 */
	public boolean saveOrUpdateEmployee(EmployeeDTO dto) throws SQLException{
		Employee employee1 = new Employee();
		if (dto.getEmployeeid() != null) {
			employee1 = (Employee) employeeDAO.selectByPrimaryKey(dto.getEmployeeid());
			if (employee1 != null) {
				// 更新新闻
			    Employee employee3 = new Employee();
				employee3.setEmployeeid(dto.getEmployeeid());
				employee3.setTitle(dto.getTitle());
				employee3.setContent(dto.getContent());
				employee3.setOperatetime(dto.getOperatetime());
				employee3.setDisplay(dto.isDisplay());

				employeeDAO.updateByPrimaryKeySelective(employee3);
				return true;
			   }
		    } else {
			   // 添加新闻
			   Employee employee2 = new Employee();
			   employee2.setEmployeeid(dto.getEmployeeid());
			   employee2.setTitle(dto.getTitle());
			   employee2.setContent(dto.getContent());
			   employee2.setOperatetime(dto.getOperatetime());
			   employee2.setDisplay(dto.isDisplay());

			   employeeDAO.insertwithid(employee2);
			  return true;
		   }
		  return false;	
	   }
	
	
    /*
     * 删除招聘
     * 
     */
	public boolean deleteEmployee(Integer employeeid) throws SQLException{
		
		try {
			// System.out.println("删除操作:"+contentid);
			employeeDAO.deleteByPrimaryKey(employeeid);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
