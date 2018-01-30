package com.sst.cxf.dao;



import java.util.List;

import com.sst.cxf.entity.Customer;

public interface CustomerDao {
	public List<Customer> customerListAll();

	public List<Customer> customerListNotDecidedZone();

	public List<Customer> customerListByDecidedZoneId(String decidedzoneid);

	public void updateDecidedZoneId(String dId, Integer[] customerIds);

	public Customer findCustomerByTelephone(String telephone);

	public String findDecidedZoneByaddress(String address);
}
