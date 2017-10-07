package com.webschool.vst.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.webschool.vst.common.Constants;
import com.webschool.vst.entity.MenuItem;

public class MenuDAOImpl implements MenuDAOInteface{
	private HibernateTemplate template;
	private ReloadableResourceBundleMessageSource message;
	
	public String buildMenuString(int roleid){
	
		String menuString="";
		if(roleid!=Constants.ROLE_GUEST){
			SessionFactory factory=template.getSessionFactory();
			Session ses=factory.openSession();
			Query query=ses.createSQLQuery(DBQuery.create_menu_string.replace("?", String.valueOf(roleid)));
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
			
			fillURL(menuList);
			String jsonStringMenu=convertToJSON(menuList);
			System.out.println(jsonStringMenu);
			/*for(MenuItem m:menuList){
				System.out.println(m);
			}*/
		}else{
			
		}
		
		
		return menuString;
	}
	/*
	 
	 private String menuid;
	private String menuname;
	private String level;
	private String parentid;
	private String order;
	private String transid;
	private String menuURL;
	private String menuUrlUI;
	private String menunameUI;
	 */

	private String convertToJSON(List<MenuItem> menuList) {
		 JSONObject jsonMenuItem = new JSONObject();
		 JSONArray jsonmenuItemArray = new JSONArray();
		 for(MenuItem menuItem:menuList){	
			
			 try {
				JSONObject jsonItem = new JSONObject();
				jsonItem.put("menuid", menuItem.getMenuid());
				jsonItem.put("menuname", menuItem.getMenuname());	
				jsonItem.put("level", menuItem.getLevel());
				jsonItem.put("parentid", menuItem.getParentid());
				jsonItem.put("order", menuItem.getOrder());
				jsonItem.put("transid", menuItem.getTransid());
				jsonItem.put("menuURL", menuItem.getMenuURL());
				jsonItem.put("menuUrlUI", menuItem.getMenuUrlUI());
				jsonItem.put("menunameUI", menuItem.getMenunameUI());
				jsonmenuItemArray.put(jsonItem);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				jsonMenuItem.put("MenuItems", jsonmenuItemArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 		
		 }
		 
		return jsonMenuItem.toString();
	}

	private void fillURL(List<MenuItem> menuList) {
		for(MenuItem menuItem:menuList){
			try{
			menuItem.setMenuUrlUI(message.getMessage(menuItem.getMenuURL(), null, null));
			menuItem.setMenunameUI(message.getMessage(menuItem.getMenuname(), null, null));
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public ReloadableResourceBundleMessageSource getMessage() {
		return message;
	}

	public void setMessage(ReloadableResourceBundleMessageSource message) {
		this.message = message;
	}

		
}
