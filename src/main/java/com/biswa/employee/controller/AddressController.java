package com.biswa.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.employee.service.AddressService;
import com.biswa.entity.Address;

@RequestMapping("/address")
@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/addNewAddress")
	public String createNewAddress(@RequestParam String email, @RequestBody Address address) {
		addressService.saveNewAddress(address,email);
		return "save Address Successfully..";
	}

}
