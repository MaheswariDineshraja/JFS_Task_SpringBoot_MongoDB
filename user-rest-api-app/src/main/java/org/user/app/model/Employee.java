package org.user.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	
	@Id
	private String id;
	
	private int EmployeeID;
	private String EmployeeName;
	private String EmployeeEmail;
	private String Location;

}
