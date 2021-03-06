package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact= contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		return contactConverter.convertContactToContactModel(contact);
	}


	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts){
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		}
		return contactsModel;
	}
	
	@Override
	public ContactModel findById(int id) {
		return contactConverter.convertContactToContactModel(contactRepository.findById(id));
	}
	
	@Override
	public void removeContact(int id) {
		Contact contact = contactConverter.convertContactModelToContact(findById(id));
		if (null != contact) {
		contactRepository.delete(contact);
		}
	}
	
	@Override
	public void updateContact(ContactModel contactModel) {
		Contact contact = contactConverter.convertContactModelToContact(findById(contactModel.getId()));
		if(null != contact){
			contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		}
		
		
	}	
}
