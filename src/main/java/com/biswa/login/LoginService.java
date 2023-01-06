package com.biswa.login;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.biswa.entity.Employee;

@Service
public interface LoginService {

	Map<String, Object> loginEmployee(Employee employee);

}
