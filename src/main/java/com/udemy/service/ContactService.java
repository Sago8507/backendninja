package com.udemy.service;

import java.util.List;

import com.udemy.model.ContactModel;

public interface ContactService {

	ContactModel addContact(ContactModel contactModel);
	
	List<ContactModel> listAllContacts();
	
}
