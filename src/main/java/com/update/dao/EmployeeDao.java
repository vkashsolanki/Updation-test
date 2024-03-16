package com.update.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.update.entity.Employee;

public class EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	// create data
	// for save data
	@Transactional
	public int insertdata(Employee employee) {

		Integer i = (Integer) this.hibernateTemplate.save(employee);
		return i;

	}

	
	  //get the single data (Object) using from id and  there is no need of Transaction for get data single & all
	  
	  public Employee getEmployee(int employee_Id) { 
		 Employee employee =this.hibernateTemplate.get(Employee.class, employee_Id);
		  return employee;
				  
	  }
	 
	  //get all data (object ) 
	  
	  public List<Employee> getAllEmployee()
	  {
		List<Employee> employees= this.hibernateTemplate.loadAll(Employee.class);
		  return employees;
	  }
	  
    //
	  
	  
	  // Delete data =>there is need transational
	  @Transactional
	  public void deleteEmployee(int employee_Id)
	  {
		 
		 Employee employee = this.hibernateTemplate.get(Employee.class, employee_Id);
		 this.hibernateTemplate.delete(employee);
	  
		 
	  }
	  
	// update data
	  
	  public void updateEmployee(int id1)
	  {
		  this.hibernateTemplate.update(id1);
		  
		  
	  }
	  
	  
	  
	  
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
