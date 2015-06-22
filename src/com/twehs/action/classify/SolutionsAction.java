package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.SolutionsService;
import com.twehs.service.classify.dto.SolutionsDTO;
//import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.Page;

public class SolutionsAction extends BaseAction {

	private Integer contentid;
	private Integer typeid;
	private String typename;
	private String title;
	private Date operatetime;
	private boolean displlay;
	private String display;
	private String smallpicaddress;
	private String smallpicname;
	private String content;

	private SolutionsService solutionsService;

	/*
	 * 分页查询
	 */
	public String findPageSolutions() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			solutionsService.findPageSolutions(page, title, typeid); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除解决方案
	 */
	public String deleteSolutions() {
		try {
			// System.out.println("delete:"+contentid);
			boolean b = solutionsService.deleteSolutions(contentid);

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
	 * 
	 * 保存和更新解决方案
	 */
	public String saveOrUpdateSolutions() {
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
			SolutionsDTO dto = new SolutionsDTO(contentid, typeid, typename,
					title, operatetime, displlay, smallpicaddress,
					smallpicname, content);

			solutionsService.saveOrUpdateSolutions(dto);
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
			this.outListString(solutionsService.findTypeType());
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

	public SolutionsService getSolutionsService() {
		return solutionsService;
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

	public void setSolutionsService(SolutionsService solutionsService) {
		this.solutionsService = solutionsService;
	}

}
