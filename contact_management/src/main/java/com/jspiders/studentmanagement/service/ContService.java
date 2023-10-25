package com.jspiders.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.studentmanagement.pojo.ContPOJO;
import com.jspiders.studentmanagement.repository.ConRepo;
@Service
public class ContService {
	private final ConRepo contactRepository;

    @Autowired
    public ContService(ConRepo contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContPOJO addContact(ContPOJO contact) {
        
        return contactRepository.save(contact);
    }

}


