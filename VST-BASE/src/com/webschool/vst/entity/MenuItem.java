package com.webschool.vst.entity;

public class MenuItem {
	
	private String menuid;
	private String menuname;
	private String level;
	private String parentid;
	private String order;
	private String transid;
	private String menuURL;
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
	
	
	

}
