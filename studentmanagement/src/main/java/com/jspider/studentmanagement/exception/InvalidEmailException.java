package com.jspider.studentmanagement.exception;



//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(value = {"stackTrace"})
public class InvalidEmailException extends Exception {

	private String msg;
	

	

}
