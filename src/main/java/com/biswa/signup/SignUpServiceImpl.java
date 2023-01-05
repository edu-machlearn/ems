package com.biswa.signup;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswa.entity.Employee;
import com.biswa.repository.EmployeeDao;

@Service
public class SignUpServiceImpl implements SignUpService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Map<String, Object> createNewEmployee(Employee employee) {
		Map<String, Object> response= new LinkedHashMap<String, Object>();
		response.clear();
		List<Employee> listOfEmail= employeeDao.findByMailId(employee.getMailId());
		List<Employee> listOfMobile= employeeDao.findByMobile(employee.getMobile());
		
		if(!listOfEmail.isEmpty())
		{
			response.put("status", "ERROR");
			response.put("message", "Mail id '"+employee.getMailId()+"' is already registered.");
		}
			
		else if(!listOfMobile.isEmpty())
		{
			response.put("status", "ERROR");
			response.put("message", "Mobile '"+employee.getMobile()+"' is already registered.");
		}
		else {
		employeeDao.save(employee);
		response.put("status", "OK");
		response.put("message", "Hello "+employee.getFname()+", You are Successfully Registered.");
		}
		return response;
	}

}
