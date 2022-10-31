package com.oatech.service;

import java.util.List;

import com.oatech.dto.Contact;


public interface IContactDtlsService {
	boolean saveContact(Contact c);
	
	List<Contact> getAllContacts();
	
	Contact getContactById(Integer cid);
	
	boolean updateContact(Contact c);
	
	boolean deleteContact(Integer cid);
	
	 

}
