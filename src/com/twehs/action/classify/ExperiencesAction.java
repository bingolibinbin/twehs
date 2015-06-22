package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.ExperiencesService;
import com.twehs.service.classify.ProjectsService;
import com.twehs.service.classify.dto.ExperiencesDTO;
import com.twehs.service.menu.TypeService;
//import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.Page;

public class ExperiencesAction extends BaseAction {

	private Integer contentid;
	private Integer typeid;
	private String typename;
	private String title;
	private Date operatetime;
	private boolean displlay; // 数据转换
	private String display;
	private String smallpicaddress;
	private String smallpicname;
	private String content;

	private ExperiencesService expService;

	/*
	 * 查询工程
	 */
	public String findPageExperiences() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			expService.findPageExperiences(page, title, typeid); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 
	 * 删除工程
	 */
	public String deleteExperiences() {
		try {
			// System.out.println("delete:"+contentid);
			boolean b = expService.deleteExperiences(contentid);

			if (b) {
				this.outString("{success:true}");
			} else {
				this.outString("{success:false,error:'该分类已被使用，不能删除'}");
			}
		} catch (Exception e) {
			this.outString("{success:false,error:'该分类已被使用，不能删除'}");
		}
		return null;
	}

	/*
	 * 保存和更新工程
	 */
	public String saveOrUpdateExperiences() {
		try {
			// boolean 类型转换处：
			// 这里需要改变上面topline的类型为Integer ,然后自定义一个Boolean类型插入下面的构造函数
			// int toplineint = Integer.parseInt(this.getTopline());
			// 从表现层想下层传输数据，从String类型转换成boolean类型
			int displayint = Integer.parseInt(this.getDisplay());
			if (displayint == 1) {
				displlay = true;
			} else {
				displlay = false;
			}

			// 这里dto里面的toplline， recommender,displlay均是有topline
			// 等由String类型转换成boolean类型
			ExperiencesDTO dto = new ExperiencesDTO(contentid, typeid,
					typename, title, operatetime, displlay, smallpicaddress,
					smallpicname, content);
			
			
		/*	System.out.println("Action层：typeid"+typeid);
			System.out.println("Action层：smallpicaddress"+smallpicaddress);
		    */
		
			

			expService.saveOrUpdateExperiences(dto);
			if (contentid == null) {
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

	/*
	 * 查询分类
	 */
	public String findTypeType() {
		try {
			// this.outListString(ttypeService.findTtypeType());
			this.outListString(expService.findTypeType());
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public Integer getContentid() {
		return contentid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public String getTypename() {
		return typename;
	}

	public String getTitle() {
		return title;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public String getDisplay() {
		return display;
	}

	public String getSmallpicaddress() {
		return smallpicaddress;
	}

	public String getSmallpicname() {
		return smallpicname;
	}

	public String getContent() {
		return content;
	}

	public ExperiencesService getExpService() {
		return expService;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setSmallpicaddress(String smallpicaddress) {
		this.smallpicaddress = smallpicaddress;
	}

	public void setSmallpicname(String smallpicname) {
		this.smallpicname = smallpicname;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setExpService(ExperiencesService expService) {
		this.expService = expService;
	}

}
