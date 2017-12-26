package com.webschool.vst.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.webschool.vst.model.CourseModel;

public class CourseDAOImpl implements CourseDAO {

	HibernateTemplate template;
	Logger log= Logger.getLogger(CourseDAOImpl.class);
	
	public boolean addCourse(CourseModel course) {
		log.info("CourseDAOImpl:addCourse started.");
		boolean status=false;
		try{
		template.save(course);
		status=true;
		}catch(DataAccessException ex){
			log.error("CourseDAOImpl : " ,ex);
			return false;
		}
		log.info("CourseDAOImpl:addCourse completed.");
		return status;
	}
	public List<CourseModel> viewCourse() {
		log.info("CourseDAOImpl:viewCourse started.");
		List<CourseModel> resultList;
		try{
			resultList=(List<CourseModel>)template.find("from CourseMaster");
		
		}catch(DataAccessException ex){
			log.error("CourseDAOImpl : " ,ex);
			return null;
		}
		log.info("CourseDAOImpl:viewCourse completed.");
		System.out.println(resultList.get(0).getCoursename());
		return resultList;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/*public CourseModel course(String courseid) {
		return template.get(CourseModel.class, courseid);
	}*/
	

}
