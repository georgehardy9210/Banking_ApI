package com.app.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.login.dao.LoginDAO;
import com.app.login.dao.dbutil.MySqlConnection;
import com.app.login.exception.BusinessException;
import com.app.login.model.Account;
import com.app.login.model.AccountStatus;
import com.app.login.model.Role;
import com.app.login.model.User;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUserCredentials(User user) throws BusinessException {
		boolean b = false;

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select username from User where username=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			} else {
				throw new BusinessException("Invalid Login Credentials");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // this line you should take it off before going live(production)
			throw new BusinessException("Internal error occured... Kindly contact SYSADMIN.....");
		}

		return b;
	}
	
	@Override
	public boolean isUserAdmin(User user) throws BusinessException {
		boolean b = false;

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = " SELECT username, role FROM User where username = ? and role = ?  ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, "admin");

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			} else {
				throw new BusinessException("Invalid Admin Credentials");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // this line you should take it off before going live(production)
			throw new BusinessException("Internal error occured... Kindly contact SYSADMIN.....");
		}

		return b;
	}

	
	@Override
	public boolean isUserEmployee(User user) throws BusinessException {
		boolean b = false;

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = " SELECT username, role FROM User where username = ? and role = ?  ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, "employee");

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			} else {
				throw new BusinessException("Invalid Employee Credentials");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // this line you should take it off before going live(production)
			throw new BusinessException("Internal error occured... Kindly contact SYSADMIN.....");
		}

		return b;
	}
	
	@Override
	public User getCustomerByContact(String userName) throws BusinessException {
		User customer = null;
		Account acc = null;
		AccountStatus status = null;

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "SELECT username, firstName, lastName, email, password, Account.accountId ,User.userId, balance, role, Account.status, Account.type From User  INNER JOIN Account  ON User.userId = Account.userId INNER JOIN AccountType ON Account.type = AccountType.type WHERE User.username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new User();
				acc = new Account();
				status = new AccountStatus();
				
				customer.setUserName(userName);
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setPassword(resultSet.getString("password"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setRole(resultSet.getString("role"));
				
				
				acc.setAccountId(resultSet.getInt("accountId"));
				acc.setBalance(resultSet.getDouble("balance"));
				status.setStatus(resultSet.getString("status"));

				acc.setStatus(status);

				
				
				customer.setAccount(acc);

				// // customer.setPassword(resultSet.getString("password"));
				customer.setUserId(resultSet.getInt("userId"));
//				customer.getAccount(acc.getAccountId());
				// customer.setRole((Role) resultSet.getClob("role"));
				// customer.getRole().setRole(resultSet.getString("role"));
				// customer.getRole().setRoleId(resultSet.getInt("roleId"));

			} else {
				throw new BusinessException("No customers with UserName " + userName + " in the DB");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // for test
			throw new BusinessException("Internal error occured... Kindly contact getUserbyContact SYSADMIN!!!!!....");
		}

		return customer;
	}
	
	public Account getAccountBalance(String userName) throws BusinessException {
		User customer = null;
		Account acc = null;
		AccountStatus status = null;
		

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "SELECT username, firstName, lastName, email, password, Account.accountId ,User.userId, balance, role, Account.status, Account.type From User  INNER JOIN Account  ON User.userId = Account.userId INNER JOIN AccountType ON Account.type = AccountType.type WHERE User.username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new User();
				acc = new Account();
				status = new AccountStatus();
				
				customer.setUserName(userName);
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setPassword(resultSet.getString("password"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setRole(resultSet.getString("role"));
				
				
				acc.setAccountId(resultSet.getInt("accountId"));
				acc.setBalance(resultSet.getDouble("balance"));
				status.setStatus(resultSet.getString("status"));

				acc.setStatus(status);
				
				
				
				customer.setAccount(acc);

				// // customer.setPassword(resultSet.getString("password"));
				customer.setUserId(resultSet.getInt("userId"));
//				customer.getAccount(acc.getAccountId());
				// customer.setRole((Role) resultSet.getClob("role"));
				// customer.getRole().setRole(resultSet.getString("role"));
				// customer.getRole().setRoleId(resultSet.getInt("roleId"));

			} else {
				throw new BusinessException("No customers with UserName " + userName + " in the DB");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // for test
			throw new BusinessException("Internal error occured... Kindly contact getUserbyContact SYSADMIN!!!!!....");
		}

		return acc;
	}
	
	

	public int withdrawlFromAccount(int sourceAccount, double amount) throws BusinessException {
		User customer = null;
		Account acc = null;
		AccountStatus status = null;

		try (Connection connection = MySqlConnection.getConnection()) {

			String sql = "SELECT balance from Account WHERE accountId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sourceAccount);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				int c = 0;
				customer = new User();
				acc = new Account();
				status = new AccountStatus();

				double CurrentBalance = resultSet.getDouble("balance");

				double newBalance = CurrentBalance - amount;

				String updateSql = "UPDATE Account SET balance = ? WHERE accountId = ?";
				PreparedStatement newStatement = connection.prepareStatement(updateSql);
				newStatement.setDouble(1, newBalance);
				newStatement.setInt(2, sourceAccount);
				c = newStatement.executeUpdate();
				System.out.println("UPDATE REALLY REALLY WORK");
				if (c == 0) {

					throw new BusinessException("UPDATE WENT WRONG");

				}

			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // for test
			throw new BusinessException("Internal error occured... Kindly contact getUserbyContact SYSADMIN!!!!!....");
		}

		return 1;
	}

	
	public int depositFromAccount(int targetAccount, double amount) throws BusinessException {
		User customer = null;
		Account acc = null;
		AccountStatus status = null;

		try (Connection connection = MySqlConnection.getConnection()) {

			String sql = "SELECT balance from Account WHERE accountId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, targetAccount);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				int c = 0;
				customer = new User();
				acc = new Account();
				status = new AccountStatus();

				double CurrentBalance = resultSet.getDouble("balance");

				double newBalance = CurrentBalance + amount;

				String updateSql = "UPDATE Account SET balance = ? WHERE accountId = ?";
				PreparedStatement newStatement = connection.prepareStatement(updateSql);
				newStatement.setDouble(1, newBalance);
				newStatement.setInt(2, targetAccount);
				c = newStatement.executeUpdate();
			
				if (c == 0) {

					throw new BusinessException("DEPOSIT UPDATE WENT WRONG");

				}

			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // for test
			throw new BusinessException("Internal error occured... Kindly contact getUserbyContact SYSADMIN!!!!!....");
		}

		return 1;
	
	}
	
	
	public int transferAccounts(int sourceAccount, int targetAccount, double amount) throws BusinessException {
	
			
			int depositWorked;
			int withdrawWorked;
			
			//You Add Money
			depositWorked = depositFromAccount(targetAccount,amount);
			
			//You Subtract Money
			withdrawWorked = withdrawlFromAccount(sourceAccount,amount);
			
		
			

		return 1;
	}
	
	
	//Update userName, password, firstName, lastName, email
	
	public int updateCustomer(String userName, String password, String firstName, String lastName, String email, int Userid) throws BusinessException {
		
	
		int c = 0;
		
			try(Connection connection=MySqlConnection.getConnection()) {
			
				
				
				
				String sql = "UPDATE User Set username = ?, password = ? , firstName = ? , lastName = ? , email = ? WHERE userId = ? ";	
				
				
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, firstName);
				preparedStatement.setString(4, lastName);
				preparedStatement.setString(5, email);
				preparedStatement.setInt(6, Userid);

				
				c=preparedStatement.executeUpdate();
				if(c==0) {
					throw new BusinessException("Updating username has failed... Please try again");
				
				
			}
					

				
			
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e); //for test
				throw new BusinessException("Internal UPDATE error occured... Kindly contact SYSADMIN!!!!!....");}
		

			return 1;
		
			}



	@Override
	public int modifyCustomerAccount(int id, String field) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}
	

// Create more functionality
// isAdminCredentials(User user)
// isEmployeeCredentials(User user)

// Transfer

}
