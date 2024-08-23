package org.user.app.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.user.app.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	
}