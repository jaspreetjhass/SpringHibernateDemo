package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmployeeDao;
import model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDAO;
	
	public int save(Employee employee)
	{
		
		int pk = employeeDAO.save(employee);
		
		return pk;
	}
	
	
	public void update(Employee employee)
	{
		
		employeeDAO.update(employee);

	}

	public void delete(int id)
	{
		
		employeeDAO.delete(id);
	
	}
	
	public Employee find(int id)
	{
		
		
		Employee emp = employeeDAO.find(id);
		
		return emp;
	}
	
	public List<Employee> findAll()
	{
		
		List<Employee> list  = employeeDAO.findAll();	
		
		return list;
	}
}
