package com.webschool.vst.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.webschool.vst.model.LoginModel;

public class LoginDAOImpl implements LoginDAO {

	HibernateTemplate template;
	Logger log= Logger.getLogger(LoginDAOImpl.class);
	
	public boolean addUser(LoginModel user) {
		log.info("LoginDAOImpl:addUser started.");
		boolean status=false;
		try{
		template.save(user);
		status=true;
		}catch(DataAccessException ex){
			log.error("LoginDAOImpl : " ,ex);
			return false;
		}
		log.info("LoginDAOImpl:addUser completed.");
		return status;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public LoginModel login(String userid) {
		return template.get(LoginModel.class, userid);
	}
	

}
