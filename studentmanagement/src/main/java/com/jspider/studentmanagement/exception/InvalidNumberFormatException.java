package com.jspider.studentmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidNumberFormatException extends Exception {
	 private String msg;
	   
}
