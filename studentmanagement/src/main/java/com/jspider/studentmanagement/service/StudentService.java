package com.jspider.studentmanagement.service;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.studentmanagement.exception.InvalidEmailException;
import com.jspider.studentmanagement.exception.InvalidNumberFormatException;
import com.jspider.studentmanagement.pojo.StudentPOJO;
import com.jspider.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	List<StudentPOJO> students;

	public StudentPOJO add(StudentPOJO pojo) throws InvalidEmailException, InvalidNumberFormatException {
	    if (pojo.getEmail().contains("@gmail.com")) {
	        if (String.valueOf(pojo.getContact()).length() == 10) {
	            StudentPOJO student = repository.save(pojo);
	            return student;
	        } else {
	            throw new InvalidNumberFormatException("Mobile number should be 10 digits.");
	        }
	    }
	    throw new InvalidEmailException("Email should be contain @gmail.com");
	}

	public StudentPOJO searchById(int id) {
		StudentPOJO student= repository.findById(id).orElse(null);
		return student;
	}

	public List<StudentPOJO> searchAllStudent() {
		List<StudentPOJO> students=repository.findAll();
		return students;
	}

	public StudentPOJO searchByName(String name) {
		StudentPOJO student = repository.findByName(name);
		return student;
	}

	public StudentPOJO searchByEmail(String email) {
		StudentPOJO student= repository.findByEmail(email);
		return student;
	}

//	public List<StudentPOJO> searchStudent(int min, int max) {
//		
//		TreeSet<Integer> values=new TreeSet<Integer>();
//		for(int i=min;i<=max;i++) {
//			values.add(i);
//		}
//		
//		//List<StudentPOJO> students=repository.findStudent(values);
//		//return students;
//		return students;
//	}
	
	
	
	
	
}
