package com.webschool.vst.entity;

public class MenuItem {
	
	private int menuid;
	private String menuname;
	private int level;
	private int parentid;
	private int order;
	private int transid;
	private String menuURL;
	public MenuItem(int menuid, String menuname, int level, int parentid, int order, int transid, String menuURL) {
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
