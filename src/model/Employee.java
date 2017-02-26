package model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EmpID")
	private int id;
	@Column(name="EmpName")
	private String name;
	@Column(name="EmpSalary")
	private float salary;
	@Embedded
	private Address homeAddress;
	@Embedded
	@AttributeOverrides(value={@AttributeOverride(name="city",column=@Column(name="OfficeCity")),
							   @AttributeOverride(name="street",column=@Column(name="OfficeStreet")),
							   @AttributeOverride(name="pincode",column=@Column(name="OfficePincode"))})
	private Address officeAddress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
	
	
}
