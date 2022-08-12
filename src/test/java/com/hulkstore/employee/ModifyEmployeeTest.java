package com.hulkstore.employee;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Employee;
import com.hulkstore.service.EmployeeService;

@SpringBootTest
class ModifyEmployeeTest {
	
	private static Logger LOG = LoggerFactory.getLogger(ModifyEmployeeTest.class);

	@Autowired 
	private EmployeeService employeeService;
	
	@Test
	void modifyEmployee() {
		LOG.info("---------Modify user---------");
		List<Employee> employees = employeeService.findAll();
		if (employees == null) { 
			LOG.info("Schema Employees is empty");
		} else {
			Employee employee = employeeService.findByUserName("user1");
			if(employee == null) {
				LOG.info("User doesnt exist on database");
			}
			else {
				employee.setEmail("xxxx@gmail.com");	
				Employee employeeRes = employeeService.modify(employee);
				assertTrue(employeeRes.getFirstName().equals(employee.getFirstName()));
			}
			
		}
		LOG.info("---------Modify user---------");
	}
}
