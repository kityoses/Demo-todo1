package com.hulkstore.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hulkstore.model.Employee;
import com.hulkstore.repo.EmployeeRepo;
import com.hulkstore.service.EmployeeService;

/**
 * @author coses
 *
 */
@Service
public class EmployeeServiceImpl implements UserDetailsService, EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee findByUserName(String userName) {
		return employeeRepo.findByUserName(userName);
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();	
	}
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee modify(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@Override
	public void delete(Employee employee) {
		employeeRepo.delete(employee);
	}
	
	@Override
	public Employee getEmployeeSession() {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		 UserDetails userDetail = (UserDetails)auth.getPrincipal(); 
		 String usuario = userDetail.getUsername();
		 return this.findByUserName(usuario);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		Employee user = this.findByUserName(username);
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("USER"));
		return new User(user.getUserName(), user.getPassword(), roles);
	}
}
