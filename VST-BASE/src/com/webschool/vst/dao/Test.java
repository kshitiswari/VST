package com.webschool.vst.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.servlet.support.RequestContextUtils;


public class Test {
	ApplicationContext e;
	
	RequestContextUtils d;
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
				
	}
	
	public String getTable() {
		String ss="";
		SessionFactory factory= template.getSessionFactory();
		Session s= factory.openSession();
		Query q=s.createSQLQuery("select * from employee");
		List res=q.list();
		for(int r=0;r<res.size();r++){
				Object p[]=(Object[])res.get(r);
				for(int k=0;k<p.length;k++)
						ss=ss+p[k];
			ss=ss+"\n";		
		
		}
		return ss;
		
		
	}
	
	
}
