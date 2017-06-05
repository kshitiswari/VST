package com.webschool.vst.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.webschool.vst.common.Constants;
import com.webschool.vst.entity.MenuItem;

public class MenuDAOImpl implements MenuDAOInteface{
	private HibernateTemplate template;
	
	public String buildMenuString(int roleid){
	
		String menuString="";
		if(roleid!=Constants.ROLE_GUEST){
			SessionFactory factory=template.getSessionFactory();
			Session ses=factory.openSession();
			Query query=ses.createSQLQuery(DBQuery.create_menu_string);
			//query.setParameter(0, roleid);
			/*
			 /*String ss="";
		SessionFactory factory= template.getSessionFactory();
		Session s= factory.openSession();
		Query q=s.createSQLQuery("select * from menus");
		List res=q.list();
		for(int r=0;r<res.size();r++){
				Object p[]=(Object[])res.get(r);
				for(int k=0;k<p.length;k++)
						ss=ss+p[k];
			ss=ss+"\n";		
		
		
		//}
			 */
			List menuListDB=query.list();
			List<MenuItem> menuList= new ArrayList<MenuItem>();
			MenuItem item;
			
			for(int r=0;r<menuListDB.size();r++){
				Object p[]=(Object[])menuListDB.get(r);
				//select a.menuid,a.menuname,a.level,a.parentid,a.order,a.transid ,b.transurl
				item=new MenuItem(String.valueOf(p[0]),(String)p[1],String.valueOf(p[2]), String.valueOf(p[3]),String.valueOf(p[4]),String.valueOf(p[5]),(String) p[6]);
				menuList.add(item);
			}
			
			for(MenuItem m:menuList){
				System.out.println(m);
			}
		}else{
			
		}
		
		
		return menuString;
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
}
