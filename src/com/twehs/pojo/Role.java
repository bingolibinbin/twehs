package com.twehs.pojo;

public class Role {

	private Integer roleid;
	
	private String rolename;
	
	private String bz;

	// 这里加载一个构造函数，连表时候要使用到
	public Role(Integer roleid2) {
		// TODO Auto-generated constructor stub
		this.roleid = roleid2;
	}

	// 后加的
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}