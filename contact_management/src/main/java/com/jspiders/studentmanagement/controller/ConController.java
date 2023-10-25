package com.jspiders.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jspiders.studentmanagement.pojo.ContPOJO;
import com.jspiders.studentmanagement.response.ContResponse;
import com.jspiders.studentmanagement.service.ContService;
@RestController
@CrossOrigin
public class ConController {
	  private final ContService contactService;

	    @Autowired
	    public ConController(ContService contactService) {
	        this.contactService = contactService;
	    }
	    @PostMapping("/add")
	    public ResponseEntity<ContPOJO> addContact(
	        @RequestPart("photoFile") MultipartFile photoFile,
	        @RequestPart("contact") ContPOJO contact
	    ) {
	        // Handle the photoFile (MultipartFile) separately, if needed
	        // For example, save the photo to a specific location and set the corresponding field in the contact object
	        
	        // Ensure that the contact object is populated with other form data
	        
	        ContPOJO addedContact = contactService.addContact(contact);
	        return new ResponseEntity<>(addedContact, HttpStatus.CREATED);
	    }
	

}
