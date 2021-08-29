/**
 * 
 */
package com.greatlearning.employee.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.greatlearning.employee.model.Employee;

/**
 * 
 * Default Implementaion of ICredential Service
 * @author Parthiban Ilango
 *
 */
public class CredentialServiceImpl implements ICredentialService {
	
	private static final String STR_AT_THE_RATE = "@";

	private static final String EMPTY_STRING = "";

	private static final String SPECIAL_CHARACTERS_ALLOWED = "!@#$%^&*_=+-/.?<>)";

	private static final String STR_DOT = ".";
	
	private static final String COMPANY_NAME = "abc";
	
	private static final String COMPANY_EMAIL_DOMAIN_NAME = "com";
	
	private static final int PASSWORD_LENGTH = 8; 
	
	/* (non-Javadoc)
	 * @see com.greatlearning.employee.service.ICredentialService#generatePassword(com.greatlearning.employee.model.Employee)
	 */
	@Override
	public String generatePassword(Employee employee) {
		employee.setPassword(generatePassword());
		return employee.getPassword();
	}

	/* (non-Javadoc)
	 * @see com.greatlearning.employee.service.ICredentialService#generateEmail(com.greatlearning.employee.model.Employee)
	 */
	@Override
	public String generateEmail(Employee employee) {
		StringBuilder sb = new StringBuilder();
		sb.append(employee.getFirstName() != null ?employee.getFirstName():EMPTY_STRING)
			.append(employee.getLastName() != null ?employee.getLastName():EMPTY_STRING)
			.append(STR_AT_THE_RATE)
			.append(employee.getDepartment() != null && getDepartmentMap().containsKey(employee.getDepartment()) ? getDepartmentMap().get(employee.getDepartment()):EMPTY_STRING)
			.append(STR_DOT)
			.append(COMPANY_NAME)
			.append(STR_DOT)
			.append(COMPANY_EMAIL_DOMAIN_NAME);
		
		employee.setEmailAddress(sb.toString());
		return employee.getEmailAddress();
	}

	/* (non-Javadoc)
	 * @see com.greatlearning.employee.service.ICredentialService#showCredentials(com.greatlearning.employee.model.Employee)
	 */
	@Override
	public String showCredentials(Employee employee) {
		StringBuilder sb = new StringBuilder("Dear ");
		sb.append(employee.getFirstName());
		sb.append(" your generated Credentials are as Follows");
		sb.append(System.lineSeparator());
		sb.append("Email --> ");
		sb.append(employee.getEmailAddress());
		sb.append(System.lineSeparator());
		sb.append("Password --> ");
		sb.append(employee.getPassword());
		return sb.toString();
	}
	
	/**
	 * 
	 * @return department code conversion map
	 */
	private Map<String, String> getDepartmentMap() {
		Map<String,String> map= new HashMap<>();
		map.put("Technical", "tech");
		map.put("Admin", "adm");
		map.put("Human Resource", "hr");
		map.put("Legal" , "lg");
		return map;
	}
	
	/**
	 * generates pwd
	 * with minimum of one uppercase, lowercase, number, one spl char from ("!@#$%^&*_=+-/.?<>)")
	 * @return password with 8 char length
	 */
	public String  generatePassword(){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<PASSWORD_LENGTH;i++) {
			sb.append(generateRandomChar(i));
		}
		return(sb.toString());
	}

	/**
	 * @param i
	 * @return generated random char for password
	 */
	private char generateRandomChar(int i) {
		Random r = new Random();
		String randomchoices = "luns";
		char randChar;
		if(i<4) {
			randChar = randomchoices.charAt(i);
		}else {
			randChar = randomchoices.charAt(r.nextInt(randomchoices.length()));
		}
		char c;
		switch(randChar){
			case 'l':
				c = (char)(r.nextInt(26) + 'a');
				break;
			case 'u':
				c = (char)(r.nextInt(26) + 'A');
				break;
			case 's':
				c = SPECIAL_CHARACTERS_ALLOWED.charAt(r.nextInt(SPECIAL_CHARACTERS_ALLOWED.length()));
				break;
			case 'n':
				c = (char)(r.nextInt(10) + '0');
				break;
			default:
				c='z';
		
		}
		return c;
	}


}
