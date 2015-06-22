package com.twehs.action.company;

import com.twehs.action.BaseAction;
import com.twehs.service.classify.dto.NewsDTO;
import com.twehs.service.company.CompanyService;
import com.twehs.service.company.dto.CompanyDTO;
//import com.twehs.service.menu.TypeService;
//import com.twehs.service.menu.dto.TypeDTO;
import com.twehs.utils.pubutil.Page;

public class CompanyAction extends BaseAction {

	private Integer companyid;
	private String companyname;
	private String profession;
	private String area;
	private String website;
	private String connector;
	private String phoneno;
	private String mobileno;
	private String fax;
	private String postcode;
	private String email;
	private String content;

	private CompanyService companyService;

	/*
	 * 分页查询公司
	 */
	public String findPageCompanys() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			companyService.findPageCompanys(page); // 这里需要修改，需要加入动态获取的用户输入参数；
			this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	/*
	 * 删除公司
	 */
	public String deleteCompanys() {
		try {
			// System.out.println("delete:"+contentid);
			boolean b = companyService.deleteCompanys(companyid);

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
	 * 更新和加入公司
	 */
	public String saveOrUpdateCompany() {
		try {
			CompanyDTO dto = new CompanyDTO(companyid, companyname, profession,
					area, website, connector, phoneno, mobileno, fax, postcode,
					email, content);

			/*
			 * System.out.println("action: companyid"+companyid);
			 * System.out.println("action: companyname"+companyname);
			 */

			companyService.saveOrUpdateCompany(dto);
			if (companyid == null) {
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

	public Integer getCompanyid() {
		return companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public String getProfession() {
		return profession;
	}

	public String getArea() {
		return area;
	}

	public String getWebsite() {
		return website;
	}

	public String getConnector() {
		return connector;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public String getMobileno() {
		return mobileno;
	}

	public String getFax() {
		return fax;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getEmail() {
		return email;
	}

	public String getContent() {
		return content;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

}
