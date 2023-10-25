package com.jspiders.studentmanagement.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.studentmanagement.pojo.ContPOJO;
import com.jspiders.studentmanagement.pojo.Contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContResponse {
	private String msg;
	private ContPOJO contact;
	private List<ContPOJO> contacts;

}
