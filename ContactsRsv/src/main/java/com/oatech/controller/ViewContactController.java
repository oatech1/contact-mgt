package com.oatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oatech.dto.Contact;
import com.oatech.service.IContactDtlsService;
@Controller
public class ViewContactController {
	@Autowired
	private IContactDtlsService service;
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model m) {
		Contact c=service.getContactById(contactId);
		m.addAttribute("contact", c);
		//System.out.println(c);
		return "index";
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contacId) {
		boolean isDeleted=service.deleteContact(contacId);
		if(isDeleted) {
			return "redirect:/viewcontacts";
		}
		return null;
		
	}
}
