package com.update;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.update.dao.EmployeeDao;
import com.update.entity.Employee;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // load xml file
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeeDao",EmployeeDao.class); 
        
        //inserdata
       // Employee employee = new Employee(103, "GaGan KumKum", "New Delhi","8978457845");
       // int insertdata = employeeDao.insertdata(employee);
       // System.out.println("weldone "+insertdata);
        
        //for take input 
        
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        boolean go = true;
        while (true) {
        	  System.out.println("Press 1 for new add");
        	 System.out.println("Press 2 for display all employee");
             System.out.println("Press 3 for get detail single data ");
             System.out.println("Press 4 for delete");
             System.out.println("Press 5 for update");
             System.out.println("Press 6 for Exit!....");
		
        try {
        	
      int input = Integer.parseInt(bufferedReader.readLine());
      switch (input) {
	case 1:
		//add new employee and aking input from user
		System.out.println("Enter user id");
		int uid = Integer.parseInt(bufferedReader.readLine());
		
		System.out.println("Enter user name");
		String uname = bufferedReader.readLine();
		
		System.out.println("Enter user address");
	    String uaddress = bufferedReader.readLine();
	    
		System.out.println("Enter user number");
		String unumber = bufferedReader.readLine();
		Employee employee = new Employee();
		employee.setId(uid);
		employee.setName(uname);
		employee.setAddress(uaddress);
		employee.setNumber(unumber);
		
		//saving obejct employeeDao
		
		int r = employeeDao.insertdata(employee);
		System.out.println(r+"Emploee added");
		
		break;
	case 2:
		//display all employee
		
		List<Employee> list= employeeDao.getAllEmployee();
		for(Employee emp:list)
		{
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getAddress());
			System.out.println(emp.getNumber());
			System.out.println("***********************************");
		}
		
		
		break;
	case 3:
		//get signle data 
		System.out.println("Enter user id");
		
		int userid = Integer.parseInt(bufferedReader.readLine());
		
       Employee employee2= employeeDao.getEmployee(userid);
       System.out.println(employee2.getId());
		System.out.println(employee2.getName());
		System.out.println(employee2.getAddress());
		System.out.println(employee2.getNumber());
		System.out.println("***********************************");
      
       
		
		
		
		break;
	case 4:
		//delete employee
           System.out.println("Enter user id");
		   int id = Integer.parseInt(bufferedReader.readLine());
	       employeeDao.deleteEmployee(id);
	       System.out.println("delete employee data4");
		
		break;
	case 5:
		//update employee
		
		/*
		 * System.out.println("Enter user id"); int uid1 =
		 * Integer.parseInt(bufferedReader.readLine());
		 * 
		 * System.out.println("Enter user name"); String uname1 =
		 * bufferedReader.readLine();
		 * 
		 * System.out.println("Enter user address"); String uaddress1 =
		 * bufferedReader.readLine();
		 * 
		 * System.out.println("Enter user number"); String unumber1 =
		 * bufferedReader.readLine();
		 */
		int id1 = Integer.parseInt(bufferedReader.readLine());
		
	     employeeDao.updateEmployee(id1);
	     System.out.println("updated employee data");
		
		break;

	case 6:
		//exit
		go= false;
		break;
	}
      System.out.println("Thanks A Lot");  	
		} catch (Exception e) {
			System.out.println("Invalid ");
			System.out.println(e.getMessage());
		}
       
        } 
        
    }
    
}
