package com.biswa.signup;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.biswa.entity.Employee;

@Service
public interface SignUpService {
	Map<String, Object> createNewEmployee(Employee employee);

}
