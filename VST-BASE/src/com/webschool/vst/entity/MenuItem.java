package com.webschool.vst.entity;

public class MenuItem {
	
	private String menuid;
	private String menuname;
	private String level;
	private String parentid;
	private String order;
	private String transid;
	private String menuURL;
	private String menuUrlUI;
	private String menunameUI;

	public MenuItem(String menuid, String menuname, String level, String parentid, String order, String transid,
			String menuURL) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.level = level;
		this.parentid = parentid;
		this.order = order;
		this.transid = transid;
		this.menuURL = menuURL;
	}
	@Override
	public String toString() {
		return "MenuItem [menuid=" + menuid + ", menuname=" + menuname + ", level=" + level + ", parentid=" + parentid
				+ ", order=" + order + ", transid=" + transid + ", menuURL=" + menuURL + "]";
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuURL() {
		return menuURL;
	}
	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	public String getMenuUrlUI() {
		return menuUrlUI;
	}
	public void setMenuUrlUI(String menuUrlUI) {
		this.menuUrlUI = menuUrlUI;
	}
	public String getMenunameUI() {
		return menunameUI;
	}
	public void setMenunameUI(String menunameUI) {
		this.menunameUI = menunameUI;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getTransid() {
		return transid;
	}
	public void setTransid(String transid) {
		this.transid = transid;
	}
	
	
	
	
	

}
