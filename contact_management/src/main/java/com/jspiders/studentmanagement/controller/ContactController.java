package com.jspiders.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.studentmanagement.pojo.Contact;
import com.jspiders.studentmanagement.response.ContactResponse;
import com.jspiders.studentmanagement.service.ContactService;

@RestController
@CrossOrigin("*")
public class ContactController {
	@Autowired
	private ContactService service;

	@PostMapping("/addContact")
	public ResponseEntity<?> addContact(@RequestBody Contact contact) {

		Contact person1 = service.addcontact(contact);

		if (person1 != null) {

			return new ResponseEntity<ContactResponse>(
					new ContactResponse("contact added Successfully ...!", contact, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<ContactResponse>(new ContactResponse("contact not added  ...!", null, null),
				HttpStatus.NOT_ACCEPTABLE);

	}

	@GetMapping("/listContact")
	public ResponseEntity<?> listContact() {

		List<Contact> contacts = service.findallContact();

		if (contacts.isEmpty() == false) {
			return new ResponseEntity<ContactResponse>(
					new ContactResponse(null, null, contacts), HttpStatus.OK);

		}
		return new ResponseEntity<ContactResponse>(new ContactResponse("Contact data Not found ", null, null),
				HttpStatus.NOT_FOUND);

	}


	
	@PostMapping("/editContact")
	public ResponseEntity<?> editContact(@RequestBody Contact contact){
		
		Contact person =service.editContact(contact);
		if (person != null ) {
			return new ResponseEntity<ContactResponse>
						(new ContactResponse(null, contact, null),HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<ContactResponse>
		(new ContactResponse(null, contact, null),HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable int id){
		Contact contact =service.deleteContact(id);
		if (contact != null) {
			return new ResponseEntity<ContactResponse>
					(new ContactResponse("Contact deleted Successfully", contact, null),HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<ContactResponse>     
				(new ContactResponse("Contact deleted Successfully", contact, null),HttpStatus.ACCEPTED);
	}

	@GetMapping("/findContactById/{id}")
	public ResponseEntity<?> findContactById(@PathVariable int id){
		
		Contact contact= service.findContactById(id);
		//Contact contact=null;
		if (contact != null) {
			return new ResponseEntity<ContactResponse>
				(new ContactResponse("Contact Found Successfully", contact, null),HttpStatus.OK);
		}

		return new ResponseEntity<ContactResponse>
			(new ContactResponse("Contact not Found ", null, null),HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/findByName/{name}")
//	public ResponseEntity<?> findByName(@PathVariable String name) {
//
//		List<Contact> contact = service.findContactByName(name);
//
//		if (contact.isEmpty() == false) {
//			return new ResponseEntity<ContactResponse>(new ContactResponse("contact found", null, contact),
//					HttpStatus.FOUND);
//		}
//
//		return new ResponseEntity<ContactResponse>(new ContactResponse("Contact data Not found", null, null),
//				HttpStatus.NOT_FOUND);
//	}
//	

//	@GetMapping("/findByContact/{contact}")
//	public ResponseEntity<?> findByContact(@PathVariable long contact) {
//		
//		
//		List<Contact> cont = service.findContactByContact(contact);
//
//		if (cont.isEmpty()==false) {
//			return new ResponseEntity<ContactResponse>(new ContactResponse(null, null, cont),
//					HttpStatus.OK);
//
//		}
//		return new ResponseEntity<ContactResponse>(new ContactResponse("Contact data not found", null, null),
//				HttpStatus.NOT_FOUND);
//	}	
	
}



