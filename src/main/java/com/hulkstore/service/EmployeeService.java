package com.hulkstore.service;

import java.util.List;

import com.hulkstore.model.Employee;

/**
 * @author coses
 *
 */
public interface EmployeeService {
	public Employee findByUserName(String userName);
	public List<Employee> findAll();
	public Employee save(Employee employee);
	public Employee modify(Employee employee);
	public void delete(Employee id);
	public Employee getEmployeeSession();
}
