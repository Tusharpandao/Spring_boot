package com.jspider.studentmanagement.repository;

import java.util.List;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.studentmanagement.pojo.StudentPOJO;

public interface StudentRepository extends JpaRepository<StudentPOJO, Integer>{

	StudentPOJO findByName(String name);

	StudentPOJO findByEmail(String email);

	
}

