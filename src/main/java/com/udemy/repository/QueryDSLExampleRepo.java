package com.udemy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {


//		private QCourse qCourse = QCourse.course;
		
	@PersistenceContext
		private EntityManager em;
		
		public void find(){
			
			
		}
	
}
