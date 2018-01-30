package test;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sst.cxf.entity.Customer;
import com.sst.cxf.service.CustomerSerivice;

public class SpringTest {
 
		public static void main(String[] args) {
			ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
			CustomerSerivice customerSerivice = (CustomerSerivice) application.getBean("customerServiceImpl");
//			List<Customer> listAll = customerSerivice.updateDecidedZoneId(dId, customerIds);
//			System.out.println(listAll);
		 }
}
