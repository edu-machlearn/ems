package com.biswa.employee.service;

import org.springframework.stereotype.Service;
import com.biswa.entity.Address;

@Service
public interface AddressService {
	Address saveNewAddress(Address address, String email);
}
