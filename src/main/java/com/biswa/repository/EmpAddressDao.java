package com.biswa.repository;

import org.springframework.data.repository.CrudRepository;

import com.biswa.entity.Address;

public interface EmpAddressDao extends CrudRepository<Address, Integer> {

}
