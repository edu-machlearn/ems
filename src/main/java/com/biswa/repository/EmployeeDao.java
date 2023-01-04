package com.biswa.repository;

import org.springframework.data.repository.CrudRepository;

import com.biswa.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
