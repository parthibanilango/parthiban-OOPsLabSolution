package com.greatlearning.employee.service;

import com.greatlearning.employee.model.Employee;

/**
 * 
 * Interface Credential service which has definitions for
 * generatePassword, generateEmailAddress, & showCredentials 
 * 
 * @author Parthiban Ilango
 *
 */
public interface ICredentialService {
	
	/**
	 * @param employee
	 * @return password
	 */
	public String generatePassword(Employee employee);
	
	/**
	 * @param employee
	 * @return email address
	 */
	public String generateEmail(Employee employee);
	
	/**
	 * @param employee
	 * @return show credentials string
	 */
	public String showCredentials(Employee employee);
	

}
