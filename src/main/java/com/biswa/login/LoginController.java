package com.biswa.login;

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
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/loginEmp")
	public ResponseEntity<Object> loginEmployee(@RequestBody Employee employee) {
		Map<String, Object> response = loginService.loginEmployee(employee);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
