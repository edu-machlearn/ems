package com.biswa.signup;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.entity.Employee;

@RequestMapping("/employee")
@RestController
public class SignUpController {

	@Autowired
	SignUpService signUpService;

	@PostMapping("/saveEmp")
	public ResponseEntity<Object> createNewEmployee(@RequestBody Employee employee) {
		Map<String, Object> response = signUpService.createNewEmployee(employee);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
