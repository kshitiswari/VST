package com.webschool.vst.dao;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.servlet.support.RequestContextUtils;


public class Test implements Serializable{
	ApplicationContext e;
	
	RequestContextUtils d;
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
				
	}
	
	public String getTable() {
		/*String ss="";
		SessionFactory factory= template.getSessionFactory();
		Session s= factory.openSession();
		Query q=s.createSQLQuery("select * from menus");
		List res=q.list();
		for(int r=0;r<res.size();r++){
				Object p[]=(Object[])res.get(r);
				for(int k=0;k<p.length;k++)
						ss=ss+p[k];
			ss=ss+"\n";		*/
		
		
		//}
		ApplicationContext context  = new ClassPathXmlApplicationContext("VST-servlet.xml");
		ReloadableResourceBundleMessageSource message=(ReloadableResourceBundleMessageSource)context.getBean("messageSource");
		MenuDAOImpl dl= new MenuDAOImpl();
		dl.setTemplate(template);
		dl.setMessage(message);
		dl.buildMenuString(1);
		return "inside MenuDAOImpl";
		
	}
	
	
}
