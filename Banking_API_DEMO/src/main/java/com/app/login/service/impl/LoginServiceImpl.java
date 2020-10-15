package com.app.login.service.impl;

import com.app.login.dao.LoginDAO;
import com.app.login.dao.impl.LoginDAOImpl;
import com.app.login.exception.BusinessException;
import com.app.login.model.Account;
import com.app.login.model.User;
import com.app.login.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDAO dao=new LoginDAOImpl();
	@Override
	public boolean isValidUserCredentials(User user) throws BusinessException {
		boolean b = false;
		
		if(user!=null && user.getUserName()!=null && user.getPassword()!=null && user.getPassword().matches("[a-z]{0,100}")) {
			b=dao.isValidUserCredentials(user);
			
		}else {
			throw new BusinessException("Invalid Login FROM ValidUSER CREDENTIALS!! wCredentials");
		}
		return b;
	}

	@Override
	public boolean isUserAdmin(User user) throws BusinessException {
		boolean b = false;
		
		if(user!=null && user.getUserName()!=null && user.getPassword()!=null && user.getPassword().matches("[a-z]{0,100}")) {
			b=dao.isUserAdmin(user);
			System.out.println("THE SQL STATE WORKED!!!!");
			
		}else {
			throw new BusinessException("No Admin Credentials");
		}
		return b;
	}
	
	@Override
	public boolean isUserEmployee(User user) throws BusinessException {
		boolean b = false;
		
		if(user!=null && user.getUserName()!=null && user.getPassword()!=null && user.getPassword().matches("[a-z]{0,100}")) {
			b=dao.isUserEmployee(user);
			System.out.println("THE SQL STATE WORKED!!!!");
			
		}else {
			throw new BusinessException("No Admin Credentials");
		}
		return b;
	}
	
	
	
	@Override
	public User getCustomerByContact(String userName) throws BusinessException {


		User user = null;

		user = dao.getCustomerByContact(userName);
		
		
		return user;
		
	}
	public int withdrawlFromAccount(int user, double amount) throws BusinessException {

		int b = 0;
			
		int c = dao.withdrawlFromAccount(user, amount);
		if(c == 0) {
			System.out.println("WithdrawlFromAccount has failed");
			
		}else {
			System.out.println("Update has worked!");
			
			 b = 1;
		}
		
			return b;
	}
	
	public int depositFromAccount(int user, double amount) throws BusinessException {

		int b = 0;
			
		int c = dao.depositFromAccount(user, amount);
		if(c == 0) {
			System.out.println("DepositFromAccount has failed");
			
		}else {
			System.out.println("DepositFromAccount has worked!");
			
			 b = 1;
		}
		
			return b;
	}

	public int transferAccounts(int sourceAccountId, int targetAccountId, double amount) throws BusinessException {

		
		int b = 0;
		
		int c = dao.transferAccounts(sourceAccountId, targetAccountId, amount);
		if(c == 0) {
			System.out.println("Update has failed");
			
		}else {
			System.out.println("Update has worked!");
			
			 b = 1;
		}
		
			return b;
		
		
	}


	


	@Override
	public int updateCustomer(String userName, String password, String firstName, String lastName, String email, int oldUserName) throws BusinessException {
	
			int i = dao.updateCustomer(userName, password, firstName, lastName, email, oldUserName);
		
			if(i ==0) {
				
				return 0;
				
			}
			
			else {
				
				return 0;
			}
			
	}
	

	

	@Override
	public int modifyCustomerAccount(int id, String field) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account getAccountBalance(String userName) throws BusinessException {
		// TODO Auto-generated method stub
		
		Account acc = new Account();
		acc = dao.getAccountBalance(userName);
		
		return acc;
	}

	
	
	
	
	
	
}
