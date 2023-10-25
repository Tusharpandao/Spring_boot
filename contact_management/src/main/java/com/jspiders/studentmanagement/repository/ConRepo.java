package com.jspiders.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.studentmanagement.pojo.ContPOJO;

public interface ConRepo extends JpaRepository<ContPOJO, Integer> {

}
