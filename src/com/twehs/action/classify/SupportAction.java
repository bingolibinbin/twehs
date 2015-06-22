package com.twehs.action.classify;

import java.util.Date;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.SupportService;
import com.twehs.service.classify.dto.SupportDTO;
import com.twehs.utils.pubutil.Page;

public class SupportAction extends BaseAction {

	private Integer contentid;
	private Integer typeid;
	private String typename;
	private String title;
	private Date operatetime;
	private String display;
	private boolean displlay; // 为数据转换设置
	private String content;

	private SupportService supportService;

	
	/*
	 * 
	 * 动态查找支持
	 */
	public String findPageSupports() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			supportService.findPageSupports(page, title, typeid); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	
	/*
	 * 
	 * 删除支持
	 */
	public String deleteSupports() {
		try {
			// System.out.println("delete:"+contentid);
			boolean b = supportService.deleteSupports(contentid);

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
	 * 保存/修改支持 这里没有用到，在前台可能会使用
	 */
	public String saveOrUpdateSupports() {

		try {
			// boolean 类型转换处：
			// 这里需要改变上面topline的类型为Integer ,然后自定义一个Boolean类型插入下面的构造函
			int displayint = Integer.parseInt(this.getDisplay());
			if (displayint == 1) {
				displlay = true;
			} else {
				displlay = false;
			}
			// 这里dto里面的toplline， recommender,displlay均是有topline
			// 等由String类型转换成boolean类型
			SupportDTO dto = new SupportDTO(contentid, typeid, typename, title,
					operatetime, displlay, content);
			supportService.saveOrUpdateSupports(dto);
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
	 * 
	 * 查询支持分类 没有用到
	 */
	public String findTypeType() {
		try {
			this.outListString(supportService.findTypeType());
			// 因为查询分类涉及到不同的menuid，所以讲查询分类方法集成到各个栏目自己的业务逻辑
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

	public String getContent() {
		return content;
	}

	public SupportService getSupportService() {
		return supportService;
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

	public void setContent(String content) {
		this.content = content;
	}

	public void setSupportService(SupportService supportService) {
		this.supportService = supportService;
	}

}
