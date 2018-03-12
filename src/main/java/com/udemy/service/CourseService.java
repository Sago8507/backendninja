package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

public interface CourseService {

//	List<Course> listAllCourse();
//	Course addCourse(Course course);
//	int removeCourse(int id);
//	Course updateCourse(Course course);

	List<CourseModel> listAllCourse();
	CourseModel addCourse(CourseModel courseModel);
	int removeCourse(String name, int price);
	CourseModel updateCourse(CourseModel courseModel);
	
}
