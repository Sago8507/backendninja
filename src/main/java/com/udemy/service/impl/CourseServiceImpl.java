package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;


	@Override
	public List<CourseModel> listAllCourse() {
		LOG.info("Call: CourseServiceImpl.listAllCourse()");
		List<Course> courses = courseJpaRepository.findAll();
		List<CourseModel> coursesModel = new ArrayList<CourseModel>();
		for(Course course: courses){
			coursesModel.add(courseConverter.entityToModel(course));
		}
		return coursesModel;
	}


	@Override
	public CourseModel addCourse(CourseModel courseModel) {
		LOG.info("Call: CourseServiceImpl.addCourse() ");
		Course course = courseJpaRepository.save(courseConverter.modelToEntity(courseModel));
		return courseConverter.entityToModel(course);
	}


	@Override
	public int removeCourse(CourseModel courseModel) {
		LOG.info("Call: CourseServiceImpl.removeCourse() ");
		Course course = courseJpaRepository.findByNameOrPrice(courseModel.getName(), courseModel.getPrice());
		if (course == null){
			LOG.info("Valor 'course' es null");
		}else{
			LOG.info("Datos: delete" + course.toString());
		}
		courseJpaRepository.delete(course.getId());
		return 0;
	}


	@Override
	public CourseModel updateCourse(CourseModel courseModel) {
		LOG.info("CourseServiceImpl.updateCourse() ");
		Course course = courseJpaRepository.findByName(courseModel.getName());
		if (course != null && course.getName().equals(courseModel.getName())){
			LOG.info("Datos update: " + course.toString());
		}else{
			LOG.info("Valor 'course' es null");
		}
		course = courseJpaRepository.save(course);
		return courseConverter.entityToModel(course);
	}
	
//	@Override
//	public List<Course> listAllCourse() {
//		LOG.info("Call: CourseServiceImpl.listAllCourse()");
//		return courseJpaRepository.findAll();
//	}
//
//	@Override
//	public Course addCourse(Course course) {
//		LOG.info("Call: CourseServiceImpl.addCourse() ");
//		CourseModel
//		return courseJpaRepository.save(course);
//	}
//
//	@Override
//	public int removeCourse(int id) {
//		courseJpaRepository.delete(id);
//		return 0;
//	}
//
//	@Override
//	public Course updateCourse(Course course) {
//		return courseJpaRepository.save(course);
//	}


	
	
}
