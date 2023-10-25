package com.jspider.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.studentmanagement.exception.InvalidEmailException;
import com.jspider.studentmanagement.exception.InvalidNumberFormatException;
import com.jspider.studentmanagement.pojo.StudentPOJO;
import com.jspider.studentmanagement.response.ErrorResponse;
import com.jspider.studentmanagement.response.StudentResponse;
import com.jspider.studentmanagement.service.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/addStudent")
	public ResponseEntity<?>  addStudent(@RequestBody StudentPOJO pojo){
		 try {
		        StudentPOJO student = service.add(pojo);
		        if (student != null) {
		            return new ResponseEntity<StudentResponse>(
		                new StudentResponse("Student data added successfully", student, null),
		                HttpStatus.OK
		            );
		        }
		        return new ResponseEntity<StudentResponse>(
		            new StudentResponse("Student data not added", student, null),
		            HttpStatus.NOT_ACCEPTABLE
		        );
		    } catch (InvalidEmailException e) {
		        return new ResponseEntity<>(new ErrorResponse(e, e.getMsg() ), HttpStatus.NOT_ACCEPTABLE);
		    }catch (InvalidNumberFormatException e) {
		        return new ResponseEntity<>(new ErrorResponse(e, e.getMsg()), HttpStatus.NOT_ACCEPTABLE);
		    }
		
		
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchById(@PathVariable int id){
		
		StudentPOJO pojo= service.searchById(id);
		if (pojo != null) {
			return new ResponseEntity<StudentResponse>
									(new StudentResponse("Student data found successfully....!", pojo, null),HttpStatus.FOUND);
			
		}
		return new ResponseEntity<StudentResponse>
							(new StudentResponse("Student data not found",pojo, null),HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("/searchAll")
	public ResponseEntity<?> searchAll(){
		List<StudentPOJO> students=service.searchAllStudent();
		
		if (students.isEmpty() ==false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found Successfully", null, students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data Not found ", null, students),HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("searchName/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		
		StudentPOJO student=service.searchByName(name);
		
		if (student != null) {
			
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Student data found Successfully", student, null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Student data found Successfully", student, null),HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("searchStudentByEmail/{email}")
	public ResponseEntity<?> searchByEmail(@PathVariable String email){
		
		StudentPOJO student=service.searchByEmail(email);
		
		if (student != null) {
			
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("Student data found Successfully", student, null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("Student data found Successfully", student, null),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
}
