package com.hulkstore.employee;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Employee;
import com.hulkstore.service.EmployeeService;

@SpringBootTest
class DeleteEmployeeTest {
	
	private static Logger LOG = LoggerFactory.getLogger(DeleteEmployeeTest.class);

	@Autowired 
	private EmployeeService employeeService;
	
	@Test
	void deleteEmployee() {
		LOG.info("---------Delete user---------");
		Integer sizeBefore = employeeService.findAll().size();
		Employee employee = employeeService.findByUserName("user1");
		if (employee == null) { 
			LOG.info("User doesnt exist on database");
		}
		else {
			employeeService.delete(employee);
			Integer sizeAfter = employeeService.findAll().size();
			assertTrue(sizeAfter < sizeBefore);
		}
		
		LOG.info("---------Delete user---------");
	}
}
