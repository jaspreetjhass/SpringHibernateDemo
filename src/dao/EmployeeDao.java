package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	public int save(Employee employee)
	{
		
		Session session = sessionfactory.openSession();
		int pk = (int)session.save(employee);
		session.beginTransaction().commit();
		session.close();
		
		return pk;
	}
	
	
	public void update(Employee employee)
	{
		
		Session session = sessionfactory.openSession();
		session.update(employee);
		session.beginTransaction().commit();
		session.close();

	}

	public void delete(int id)
	{
		
		Session session = sessionfactory.openSession();
		Employee emp = new Employee();
		emp.setId(id);
		session.delete(emp);;
		session.beginTransaction().commit();
		session.close();
		
	
	}
	
	public Employee find(int id)
	{
		
		Session session = sessionfactory.openSession();
		Employee emp = (Employee)session.get(Employee.class, id);
		
		session.close();
		
		return emp;
	}
	
	public List<Employee> findAll()
	{
		
		Session session = sessionfactory.openSession();
		Query q =  session.createQuery("from Employee");
		List<Employee> list  = q.list();	
		session.close();
		
		return list;
	}
	
	
}
