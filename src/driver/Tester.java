package driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Address;
import model.Employee;
import service.EmployeeService;

public class Tester {

	public static void main(String[] args) {
		


		ApplicationContext con =  new ClassPathXmlApplicationContext("resources/spring.xml");
		EmployeeService empservice = con.getBean(EmployeeService.class);
		
		
		Employee emp1 = new Employee();
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
		int pk = empservice.save(emp1);
	
		System.out.println("record inserted in db with pk := "+pk);
		
		
	
	}
}
