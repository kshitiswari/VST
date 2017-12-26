package com.webschool.vst.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.webschool.vst.model.StudentModel;

public class StudentDAOImpl implements StudentDAO{
	HibernateTemplate template;
	Logger log= Logger.getLogger(StudentDAOImpl.class);
	
	public boolean addStudent(StudentModel student) {
		log.info("StudentDAOImpl:addStudent started.");
		boolean status=false;
		/*
		 Test Data
		 */
		
		//student.setStudentid("s100");
		//student.setFirstname("Deb");
		//student.setStudentName();
		// test data end
		try{
		template.save(student);
		status=true;
		}catch(DataAccessException ex){
			log.error("StudentDAOImpl : " ,ex);
			return false;
		}
		log.info("StudentDAOImpl:addStudent completed.");
		return status;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


}
