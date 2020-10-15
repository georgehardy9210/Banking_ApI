package com.app.login.service;

import com.app.login.exception.BusinessException;
import com.app.login.model.Account;
import com.app.login.model.User;

public interface LoginService {

	public boolean isValidUserCredentials(User user) throws BusinessException;
	public User getCustomerByContact(String userName) throws BusinessException;
	public int withdrawlFromAccount(int i, double amount) throws BusinessException;
	public int depositFromAccount(int user, double amount) throws BusinessException;
	public int transferAccounts(int i, int targetId, double amount) throws BusinessException;
	public boolean isUserAdmin(User user) throws BusinessException;
	int updateCustomer(String field1, String field2, String field3, String field4, String field5, int field6) throws BusinessException;
	boolean isUserEmployee(User user) throws BusinessException;
	int modifyCustomerAccount(int id, String field) throws BusinessException;
	public Account getAccountBalance(String userName) throws BusinessException;




}
