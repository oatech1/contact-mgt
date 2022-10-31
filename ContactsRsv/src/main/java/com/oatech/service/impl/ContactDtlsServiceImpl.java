package com.oatech.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oatech.REPO.IContactDtlsRepo;
import com.oatech.dto.Contact;
import com.oatech.entity.ContactEntity;
import com.oatech.service.IContactDtlsService;

@Service
public class ContactDtlsServiceImpl implements IContactDtlsService {
	@Autowired 
	private IContactDtlsRepo repo;
	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity=new  ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity=repo.save(entity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities=repo.findAll();
		//List<Contact> contacts=new ArrayList<Contact>();
		//BeanUtils.copyProperties(entities, contacts);
		return entities.stream().map(entity ->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		//return contacts ;
	}

	@Override
	public Contact getContactById(Integer cid) {
		 Optional<ContactEntity> opt = repo.findById(cid);
		if(opt.isPresent()) {
			ContactEntity entity=opt.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		repo.deleteById(cid);
		return true;
	}
		
	

}
