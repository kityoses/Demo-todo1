package com.hulkstore;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hulkstore.model.Employee;
import com.hulkstore.service.EmployeeService;

@SpringBootTest
class DemoInitBDTest {

	private static Logger LOG = LoggerFactory.getLogger(DemoInitBDTest.class);	
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void initBD() {

		LOG.info("---------Create user---------");
		Employee employee = new Employee();
		employee.setFirstName("Cristian");
		employee.setLastName("Oses");
		employee.setEmail("cristianoses292@gmail.com");
		employee.setUserName("user");
		employee.setStatus("ACTIVE");
		employee.setPassword(encoder.encode("1234")); //uso SecurityConfig
		employeeService.save(employee);
		LOG.info("---------Create user " + employee.getUserName() + " finalized---------");
		
		LOG.info("---------Create user---------");
		Employee employee2 = new Employee();
		employee2.setFirstName("Magali");
		employee2.setLastName("Ramini");
		employee2.setEmail("magaa.02.12@hotmail.com");
		employee2.setUserName("user1");
		employee2.setStatus("ACTIVE");
		employee2.setPassword(encoder.encode("1234"));
		employeeService.save(employee2);
		LOG.info("---------Create user " + employee2.getUserName() + " finalized---------");
		LOG.info("Users created");	
		
	}

}
