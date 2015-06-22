package com.twehs.action.menu;

import antlr.collections.List;

import com.twehs.action.BaseAction;
import com.twehs.service.menu.TypeService;
import com.twehs.utils.pubutil.Page;
import com.twehs.service.menu.dto.TypeDTO;

public class TypeAction extends BaseAction {

	private Integer typeid;
	private Integer menuid;
	private String menuname;
	private String typename;
	private String bz;

	private TypeService ttypeService;

	/*
	 * 分页查询
	 */
	public String findPageTtype() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			ttypeService.findPageTtype(page);
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 
	 * 保存和更新
	 */
	public String saveOrUpdateTtype() {
		try {
			TypeDTO dto = new TypeDTO(typeid, menuid, menuname, typename, bz);
			ttypeService.saveOrUpdateTtype(dto);
			if (typeid == null) {
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
	 * 删除Type
	 */
	public String deleteTtype() {
		try {
			boolean b = ttypeService.deleteTtype(typeid);
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
	 * 生成menu菜单
	 */
	public String findTtypeType() {
		try {
			// this.outListString(ttypeService.findTtypeType());
			this.outListString(ttypeService.findTtypeType(menuid));
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public TypeService getTtypeService() {
		return ttypeService;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public void setTtypeService(TypeService ttypeService) {
		this.ttypeService = ttypeService;
	}

}