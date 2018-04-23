package com.udemy.service;

import java.util.List;

import com.udemy.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	public abstract ContactModel  findById(int id);
	public abstract void removeContact (int id);
	public abstract void updateContact (ContactModel contactModel);
	
}
