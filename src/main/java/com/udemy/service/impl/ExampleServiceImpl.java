package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Santiago", 5));
		people.add(new Person("Omar", 32));
		people.add(new Person("Cynthia", 31));
		people.add(new Person("Laura", 33));
		people.add(new Person("Irene", 61));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
