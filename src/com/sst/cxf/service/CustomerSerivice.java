package com.sst.cxf.service;


import java.util.List;

import javax.jws.WebService;

import com.sst.cxf.entity.Customer;
@WebService
public interface CustomerSerivice {
   /**
    * 查询所有的客户
 * @return
 */
public List<Customer> customerListAll();

   /**
    * 查询没有关联定区的客户
 * @return
 */
public List<Customer> customerListNotDecidedZone();
   /**
    * 通过定区ID查询客户
 * @param decidedzoneid
 * @return
 */
public List<Customer> customerListByDecidedZoneId(String decidedzoneid);
   /**
    * 更新客户关联的定区
 * @param dId
 * @param customerIds
 */
public void updateDecidedZoneId(String dId,Integer[] customerIds);
   /**
    * 根据手机号查询客户信息
 * @param telephone
 * @return
 */
public Customer findCustomerByTelephone(String telephone);
   /**
    * 根据的地址查询客户的定区ID
 * @param address
 * @return
 */
public String findDecidedZoneByaddress(String address);

}
