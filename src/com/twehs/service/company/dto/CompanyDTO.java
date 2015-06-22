package com.twehs.service.company.dto;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.twehs.pojo.Company;
//import com.twehs.pojo.Menu;
//import com.twehs.service.menu.dto.MenuDTO;

public class CompanyDTO {

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

	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Integer companyid, String companyname, String profession,
			String area, String website, String connector, String phoneno,
			String mobileno, String fax, String postcode, String email,
			String content) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
		this.profession = profession;
		this.area = area;
		this.website = website;
		this.connector = connector;
		this.phoneno = phoneno;
		this.mobileno = mobileno;
		this.fax = fax;
		this.postcode = postcode;
		this.email = email;
		this.content = content;
	}

	public static CompanyDTO createDto(Company pojo) {
		CompanyDTO dto = null;
		if (pojo != null) {
			dto = new CompanyDTO(pojo.getCompanyid(), pojo.getCompanyname(),
					pojo.getProfession(), pojo.getArea(), pojo.getWebsite(),
					pojo.getConnector(), pojo.getPhoneno(), pojo.getMobileno(),
					pojo.getFax(), pojo.getPostcode(), pojo.getEmail(),
					pojo.getContent());
		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	public static List createDtos(Collection pojos) {
		List<CompanyDTO> list = new ArrayList<CompanyDTO>();
		if (pojos != null) {
			Iterator iterator = pojos.iterator();
			while (iterator.hasNext()) {
				Company company = (Company) iterator.next(); //
				CompanyDTO dto = createDto(company);
				list.add(dto);
			}
		}
		return list;
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

}
