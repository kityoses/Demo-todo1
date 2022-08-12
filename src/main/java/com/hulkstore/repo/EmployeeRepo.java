package com.hulkstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.model.Employee;

/**
 * @author coses
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{	
	public Employee findById(int id);
	public Employee findByUserName(String userName);
	public List<Employee> findByStatus(String status);

}
