package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao {
	
	private HibernateTemplate template;
	
	
	public HibernateTemplate getTemplate() {
		return template;
	}
	//setter DI
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	//method to save employee object
	public void save(Employee e) {
		template.save(e);
	}

	// method to update employee
	public void updateEmployee(Employee e) {
		template.update(e);
	}

	// method to delete employee
	public void deleteEmployee(Employee e) {
		template.delete(e);
	}

	// method to get employee
	public Employee getEmpById(int id) {
		Employee e = (Employee) template.get(Employee.class, id);
		return e;
	}

	// method to return all employees
	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list = template.loadAll(Employee.class);
		return list;
	}
}
