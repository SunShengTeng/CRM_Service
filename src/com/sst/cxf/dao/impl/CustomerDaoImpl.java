package com.sst.cxf.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sst.cxf.dao.CustomerDao;
import com.sst.cxf.entity.Customer;

@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{
	// 傻逼spring把jdbctempalte的set方法给final了
   @Autowired
	public void setJT(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }
	public List<Customer> customerListAll(){
    	String sql = "select * from t_customer";
    	List<Customer> list = this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");	
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
    	});
    	return list;
    }
	@Override
	public List<Customer> customerListNotDecidedZone() {
		String sql = "select * from t_customer where decidedzone_id is null";
    	List<Customer> list = this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");	
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
    	});
    	return list;
	}
	@Override
	public List<Customer> customerListByDecidedZoneId(String decidedzoneid) {
		String sql = "select * from t_customer where decidedzone_id = ?";
		List<Customer> list = this.getJdbcTemplate().query(sql, new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");	
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
    	},decidedzoneid);
    	return list;
	}
	@Override
	public void updateDecidedZoneId(String dId, Integer[] customerIds) {
		// 更具定区ID更新所有的Customer.decidedZone_id=null
		String sql1 = "update t_customer set decidedzone_id = null where decidedzone_id = ?";
	    this.getJdbcTemplate().update(sql1, dId);
	   // 重新为customerIds中的客户赋值decidedZone属性
	    String sql2 = "update t_customer set decidedzone_id = ? where id = ?";
	    for (int cId : customerIds) {
			this.getJdbcTemplate().update(sql2, dId,cId);
		}
	}
	@Override
	public Customer findCustomerByTelephone(String telephone) {
		String sql = "select * from t_customer where telephone = ?";
		Customer customer = null;
		try {
			customer = getJdbcTemplate().queryForObject(sql, new RowMapper<Customer>(){

				@Override
				public Customer mapRow(ResultSet rSet, int arg1) throws SQLException {
					int id = rSet.getInt("id");
					String name = rSet.getString("name");
					String station = rSet.getString("station");
					String telephone = rSet.getString("telephone");
					String address = rSet.getString("address");
					String did = rSet.getString("decidedzone_id");	
					return new Customer(id, name, station, telephone, address, did);
				}}, telephone);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return customer;
	}
	@Override
	public String findDecidedZoneByaddress(String address) {
		String sql = "select decidedzone_id from t_customer where address = ?";
		String decidedzoneid = null;
		try {
			decidedzoneid =  getJdbcTemplate().queryForObject(sql, String.class, address);
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return decidedzoneid;
	}
    
}
