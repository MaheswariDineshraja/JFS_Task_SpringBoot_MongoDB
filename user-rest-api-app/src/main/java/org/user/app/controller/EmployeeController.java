package org.user.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.user.app.repository.EmployeeRepository;
import org.user.app.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	  EmployeeRepository employeerepository;
	
	@GetMapping("/say")
	public String sayHello() {
		return "Hello Spring boot";
	}
	
	@GetMapping("/displayALL")
	  public ResponseEntity<List<Employee>> getAllTutorialsEntity(@RequestParam(required = false) String EmployeeName) {
		  try {
			    List<Employee> employees = new ArrayList<Employee>();
			    
			    employeerepository.findAll().forEach(employees::add);

			    if (employees.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(employees, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	@GetMapping("/display/{id}")
	  public ResponseEntity<Employee> getTutorialById(@PathVariable("id") String id) {
		  Optional<Employee> EmployeeData = employeerepository.findById(id);

		  if (EmployeeData.isPresent()) {
		    return new ResponseEntity<>(EmployeeData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

}
