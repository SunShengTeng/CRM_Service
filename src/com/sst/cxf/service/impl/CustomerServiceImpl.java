package com.sst.cxf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sst.cxf.dao.CustomerDao;
import com.sst.cxf.entity.Customer;
import com.sst.cxf.service.CustomerSerivice;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerSerivice {
    
	@Autowired
	private CustomerDao customerDaoImpl;

	@Override
	public List<Customer> customerListAll() {
		return customerDaoImpl.customerListAll();
	}

	@Override
	public List<Customer> customerListNotDecidedZone() {
		
		return customerDaoImpl.customerListNotDecidedZone();
	}

	@Override
	public List<Customer> customerListByDecidedZoneId(String decidedzoneid) {
		
		return customerDaoImpl.customerListByDecidedZoneId(decidedzoneid);
	}

	@Override
	public void updateDecidedZoneId(String dId, Integer[] customerIds) {
		
		customerDaoImpl.updateDecidedZoneId(dId,customerIds);
		
	}

	@Override
	public Customer findCustomerByTelephone(String telephone) {
		
		return customerDaoImpl.findCustomerByTelephone(telephone);
	}

	@Override
	public String findDecidedZoneByaddress(String address) {
		
		return customerDaoImpl.findDecidedZoneByaddress(address);
	}
	

}
