package com.hulkstore.employee;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hulkstore.model.Employee;
import com.hulkstore.service.EmployeeService;

@SpringBootTest
class InsertEmployeeTest {
	
	private static Logger LOG = LoggerFactory.getLogger(InsertEmployeeTest.class);

	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void insertEmployee() {
		LOG.info("---------Create user---------");
		Employee employee = new Employee();
		employee.setFirstName("Juan");
		employee.setLastName("Perez");
		employee.setEmail("juanperez@gmail.com");
		employee.setUserName("juan");
		employee.setStatus("ACTIVE");
		employee.setPassword(encoder.encode("1234"));	
		Employee employeeRes = employeeService.save(employee);
		assertTrue(employeeRes.getPassword().equalsIgnoreCase(employee.getPassword()));
		LOG.info("---------User created---------");
	}
}
