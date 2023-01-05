package com.biswa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.biswa.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{
	
	List<Employee> findByMailId(String mail);

	List<Employee> findByMobile(String mobile);

}
