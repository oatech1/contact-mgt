package com.oatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oatech.dto.Contact;
import com.oatech.service.IContactDtlsService;

@Controller
public class ContactInforController {
	@Autowired
	private IContactDtlsService service;
	
	@GetMapping(value= {"/", "/addcontact"})
	public String loadForm(Model m)  {
		Contact contact=new Contact();
		m.addAttribute("contact", contact);
		return "index";
	}
	@PostMapping(value = "/savecontact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes m) {
		boolean isSaved=service.saveContact(c);
		if(isSaved) {
			m.addFlashAttribute("succmsg", "Contact is saved");
		}else {
			m.addFlashAttribute("errmsg", "Failed to saved");
		}
		return "redirect:/usraccsuc";
	}
	@GetMapping("/viewcontacts")
	public String handleViewContacts(Model m) {
	List<Contact> contactsList	=service.getAllContacts();
	m.addAttribute("contacts", contactsList);
	return "viewContacts";
	}
	@GetMapping("/usraccsuc")
	public String usrAccCrtSuc(@ModelAttribute("contact") Contact c, Model m) {
		m.addAttribute("c", c);
		return "index";
	}

}
