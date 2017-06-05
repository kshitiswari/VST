package com.webschool.vst.dao;

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
			
			List<MenuItem> menuList=(List<MenuItem>)query.list();
			
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
