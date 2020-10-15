package com.app.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.app.login.exception.BusinessException;
import com.app.login.model.Account;
import com.app.login.model.User;

public interface LoginDAO {

	public boolean isValidUserCredentials(User user) throws BusinessException;
	public User getCustomerByContact(String userName) throws BusinessException; 
	public int withdrawlFromAccount(int user, double amount) throws BusinessException;
	public int depositFromAccount(int user, double amount) throws BusinessException;
	public int transferAccounts(int sourceAccount, int targetAccountId, double amount) throws BusinessException;
	int updateCustomer(String field1, String field2, String field3, String field4, String field5, int field6) throws BusinessException;
	public boolean isUserAdmin(User user) throws BusinessException;
	boolean isUserEmployee(User user) throws BusinessException;
	int modifyCustomerAccount(int id, String field) throws BusinessException;
	public Account getAccountBalance(String userName) throws BusinessException;


}

