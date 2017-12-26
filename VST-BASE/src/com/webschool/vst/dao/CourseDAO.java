package com.webschool.vst.dao;

import java.util.List;

import com.webschool.vst.model.CourseModel;

public interface CourseDAO {

	boolean addCourse(CourseModel course);
	 List<CourseModel> viewCourse();

}
