package com.greatlearning.admin.main;

import java.util.Scanner;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.service.CredentialServiceImpl;
import com.greatlearning.employee.service.ICredentialService;

/**
 * Driver class for admin
 * @author Parthiban Ilango
 *
 */
public class AdminService {
	
	private final static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Please enter First Name of employee");
		String firstName = sc.next();
		System.out.println("Please enter Last Name name of employee");
		String secondName = sc.next();
		Employee emp = new Employee(firstName,secondName);
		System.out.println("Please enter department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		int dept = sc.nextInt();
		// sets department from user choice to employee
		setDepartment(emp, dept);
	
		ICredentialService  credService = new CredentialServiceImpl();
			credService.generateEmail(emp);
			credService.generatePassword(emp);
		System.out.println(credService.showCredentials(emp));
	}



	/**
	 * @param emp
	 * @param dept
	 */
	private static void setDepartment(Employee emp, int dept) {
		switch(dept){
		case 1:
			emp.setDepartment("Technical");
			break;
		case 2:
			emp.setDepartment("Admin");
			break;
		case 3:
			emp.setDepartment("Human Resource");
			break;
		case 4:
			emp.setDepartment("Legal");
			break;
		default:
			System.out.println("please select correct department");
		}
	}

}
