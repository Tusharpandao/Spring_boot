package com.jspider.studentmanagement.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspider.studentmanagement.pojo.StudentPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {
	
	private String msg;
	private StudentPOJO student;
	private List<StudentPOJO> students;

}
