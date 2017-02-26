package testcases;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Address;
import model.Employee;
import service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:resources/spring.xml"})
public class EmployeeTestCases {

	@Autowired
	private EmployeeService service;
	
	@Test
	public void totalemployee()
	{
		
		//Assert.assertNotNull(service.find(5));
		Assert.assertEquals(4, service.findAll().size());
		
		
	}
	
	
	@Test
	public void employeesame()
	{
		
		Employee emp1 = new Employee();
		emp1.setId(4);
		emp1.setName("Mankirat Singh");
		emp1.setSalary(27000f);
		
		Address haddr =  new Address();
		haddr.setCity("New Delhi");
		haddr.setStreet("Hari Nagar");
		haddr.setPincode(110018);
		
		Address oaddr = new Address();
		oaddr.setCity("New Delhi");
		oaddr.setStreet("Gurgaon");
		oaddr.setPincode(122001);
		
		emp1.setOfficeAddress(oaddr);
		emp1.setHomeAddress(haddr);
		
		
		Assert.assertNull("Object is not null",service.find(4));
	}
	
	
}
