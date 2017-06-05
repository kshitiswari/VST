package com.webschool.vst.dao;

public interface DBQuery {
	String create_menu_string="select a.menuid,a.menuname,a.level,a.parentid,a.order,a.transid ,b.transurl from menus a left outer JOIN roletransaction b on a.transid=b.transid where a.transid in (select distinct roletransmap.transid from roletransmap where roletransmap.roleid=4) or a.transid=0 order by a.menuid,a.level";

}
