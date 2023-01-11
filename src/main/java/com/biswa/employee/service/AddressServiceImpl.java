package com.biswa.employee.service;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biswa.entity.Address;
import com.biswa.entity.Employee;
import com.biswa.repository.EmpAddressDao;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	EmpAddressDao empAddressDao;

	@Autowired
	EntityManager entityManager;

	@Override
	public Address saveNewAddress(Address address, String email) {

		Integer emp_id = null;
		Address saveAdd = null;
		try {
			saveAdd = empAddressDao.save(address);
			System.out.println("Insert data To Address..");
			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("getIdFromMail", Employee.class);
			spq.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter("id", Integer.class, ParameterMode.OUT);
			spq.setParameter("email", email);
			spq.execute();
			emp_id = (Integer) spq.getOutputParameterValue("id");
			int result = entityManager.createNativeQuery("update employee set address_id="+saveAdd.getID() + " where employee_id=" + emp_id)
					.executeUpdate();
			if (result > 0)
				System.out.println("Update Address in Employee table Success...");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

		return saveAdd;
	}

}
