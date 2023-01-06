package com.biswa.login;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biswa.entity.Employee;
import com.biswa.repository.EmployeeDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Map<String, Object> loginEmployee(Employee employee) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		List<Employee> emp = employeeDao.loginEmployee(employee.getMailId(), employee.getPassword());
		emp.forEach(e->{
			e.setPassword(e.getPassword().replaceAll("\\S", "*"));
		});
		
		if (emp.isEmpty()) {
			response.put("status", "ERROR");
			response.put("message", "Login Failed for the user, "+employee.getMailId());
		} else {
			response.put("status", "OK");
			response.put("message", "Login Success!");
			response.put("data", emp);
		}
		return response;
	}

}
