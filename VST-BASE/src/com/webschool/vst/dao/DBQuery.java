package com.webschool.vst.dao;

public interface DBQuery {
	String create_menu_string="select new com.webschool.vst.entity.MenuItem(a.*,a.transid as menu_tran,b.transid as roletransid,b.transurl) from menus a left outer JOIN roletransaction b on a.transid=b.transid where a.transid in (select distinct roletransmap.transid from roletransmap where roletransmap.roleid=?) or a.transid=0 order by a.menuid,a.level";

}
