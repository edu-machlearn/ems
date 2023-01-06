package com.biswa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.biswa.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	List<Employee> findByMailId(String mail);

	List<Employee> findByMobile(String mobile);

	@Query(
			value = "SELECT employee_id,password,first_name,last_name,mail_id,mobile,gender,date_of_birth,create_date_time,update_date_time FROM employee WHERE mail_id = ?1 and password = ?2", 
			nativeQuery = true)
	List<Employee> loginEmployee(String mailId, String password);

}
