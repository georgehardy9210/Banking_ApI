package com.app.bank.front.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.login.exception.BusinessException;
import com.app.login.model.Account;
import com.app.login.model.User;
import com.app.login.service.LoginService;
import com.app.login.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1324234234232342335L;
	private User user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String paths = request.getServletPath();

		switch (paths) {

		case "/updates":
			HttpSession session = request.getSession(false);
			User user1 = (User) session.getAttribute("user");
			response.sendRedirect("UpdateCreate.jsp");
			//updateUser(request, response);
			break;
		case "/logout":
			logoutUser(request, response);
			break;

		case "/displa":
			findByAccountId(request, response);
			break;

		case "findByAccountId":
			findByAccountId(request, response);
			break;

		case "findByUserId":
			findByUserId(request, response);
			break;

		case "findByStatusId":
			findByStatusId(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String paths = request.getServletPath();

		switch (paths) {

		case "/adminControl":

			try {
				selectMenu(request, response);
			} catch (BusinessException | ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;

		case "/login":

			try {
				loginUser(request, response);

			} catch (IOException | ServletException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		
			
		case "/register":
			registerUser(request,response);
			
		//	response.sendRedirect("UpdateCreate.jsp");
			//registerUser(request, response);
			break;
		case "/registerResponse":
			try {
				registerUserResponse(request,response);
			} catch (IOException | ServletException | BusinessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			//registerUser(request, response);
			break;

			
		case "/balanceResponse":
			view_BalanceResponse(request, response);
			
		case "/withdraw":
			try {

				withdrawUserResponse(request, response);

			} catch (BusinessException | ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/deposit":
			try {
				depositUserResponse(request, response);
			} catch (BusinessException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/transfer":
			try {
				transferBetweenUsersResponse(request, response);
			} catch (BusinessException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paths = request.getServletPath();

		switch (paths) {

		case "/users":
			break;

		}

	}

//SELECTMENU
	private void selectMenu(HttpServletRequest request, HttpServletResponse response)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		User user2 = (User) session.getAttribute("user");


		System.out.println("INSIDE SELECT MENU!!!!");
		String searchValue = request.getParameter("options");

		if (searchValue.equals("Withdraw")) {
			String status = (String) session.getAttribute("status");
			User user1 = (User) session.getAttribute("user");
			request.setAttribute("user", user1);
			request.setAttribute("status", status);
			request.setAttribute("selection", "withdraw");

			System.out.println("withdraw has been selected");
			withdrawUser(request, response);

		} else if (searchValue.equals("Deposit")) {
			String status = (String) session.getAttribute("status");
			User user1 = (User) session.getAttribute("user");
			request.setAttribute("user", user1);
			request.setAttribute("status", status);
			request.setAttribute("selection", "deposit");
			System.out.println("Deposit has been selected");
			depositUser(request, response);

		} else if (searchValue.equals("Transfer")) {

			User user1 = (User) session.getAttribute("user");
			request.setAttribute("user", user1);
			request.setAttribute("selection", "transfer");
			System.out.println("Transfer has been selected");
			transferBetweenUsers(request, response);

		} else if (searchValue.equals("Update")) {

			System.out.println("Update has been selected");

		} else if (searchValue.equals("Search_User")) {

			System.out.println("Search_User has been selected");

		} else if (searchValue.equals("Search_Account")) {

			System.out.println("Search_Account has been selected");

		} else if (searchValue.equals("View_Balance")) {
			
			User user1 = (User) session.getAttribute("user");
			request.setAttribute("user", user1);
			request.setAttribute("selection", "transfer");
			System.out.println("Transfer has been selected");
			view_Balance(request, response);

			System.out.println("View_Balance has been selected");

		} else if (searchValue.equals("View_All_Accounts")) {

			System.out.println("View_All_Accounts has been selected");

		}
	}// End of selectMenu

	/* 						*/

	private void view_Balance(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, BusinessException {
		// TODO Auto-generated method stub
		
		Account acc = new Account();
		HttpSession session = request.getSession(false);
		LoginService service = new LoginServiceImpl();
	 
	
		User user2 = (User) session.getAttribute("user");
		acc = service.getAccountBalance(user2.getUserName());
		
		double current = acc.getBalance();
		session.setAttribute("balance", current);

		
		
		RequestDispatcher requestDispatcher = null;
	
		
			if (true) {
				// success

				requestDispatcher = request.getRequestDispatcher("Display_Account.jsp");
				requestDispatcher.forward(request, response);
			}
		
		
		
	}
	
	
	private void view_BalanceResponse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		LoginService service = new LoginServiceImpl();
		User user1 = (User) session.getAttribute("user");
		User user2 = (User) session.getAttribute("user");
		String status2 = user1.getRole();
		session.setAttribute("status", status2);
		

		RequestDispatcher requestDispatcher = null;
		
//		try {
			if (true) {
				// success

				requestDispatcher = request.getRequestDispatcher("Main.jsp");
				requestDispatcher.forward(request, response);
			}
	}

	private void transferBetweenUsersResponse(HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

		User user1 = (User) session.getAttribute("user");
		String status = (String) session.getAttribute("status");

		request.setAttribute("status", status);

		System.out.println("Inside withdrawUserResponse1");

		LoginService service = new LoginServiceImpl();

		System.out.println("Inside withdrawUserResponse2");

		int targetId = Integer.parseInt(request.getParameter("accountId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		// RequestDispatcher requestDispatcher = null;

		System.out.println("Inside withdrawUserResponse3333");

		service.transferAccounts(user1.getAccount().getAccountId(),targetId, amount);
		session.setAttribute("user", user1);
		request.setAttribute("user", user1);
		request.setAttribute("status", status);
		String status2 = user1.getRole();
		session.setAttribute("status", status2);
		

		RequestDispatcher requestDispatcher = null;
	

			if (true) {
				// success

				requestDispatcher = request.getRequestDispatcher("Main.jsp");
				requestDispatcher.forward(request, response);
			}

	}

	private void transferBetweenUsers(HttpServletRequest request, HttpServletResponse response)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);

		User user1 = (User) session.getAttribute("user");
		LoginService service = new LoginServiceImpl();

		RequestDispatcher requestDispatcher = null;

		String selection = "transfer";

		session.setAttribute("selection", selection);

		requestDispatcher = request.getRequestDispatcher("WithdrawTransferDepo.jsp");
		requestDispatcher.forward(request, response);

	}



	private void depositUserResponse(HttpServletRequest request, HttpServletResponse response)
			throws BusinessException, ServletException, IOException {

		HttpSession session = request.getSession(false);

		User user1 = (User) session.getAttribute("user");
		String status = (String) session.getAttribute("status");

		request.setAttribute("status", status);

		System.out.println("Inside withdrawUserResponse1");

		LoginService service = new LoginServiceImpl();

		System.out.println("Inside withdrawUserResponse2");

		double amount = Double.parseDouble(request.getParameter("amount"));
		// RequestDispatcher requestDispatcher = null;

		System.out.println("Inside withdrawUserResponse3333");

		service.depositFromAccount(user1.getAccount().getAccountId(), amount);
		session.setAttribute("user", user1);
		request.setAttribute("user", user1);
		request.setAttribute("status", status);
		String status2 = user1.getRole();
		session.setAttribute("status", status2);
		

		RequestDispatcher requestDispatcher = null;
	

			if (true) {
				// success

				requestDispatcher = request.getRequestDispatcher("Main.jsp");
				requestDispatcher.forward(request, response);
			}
	}

	private void depositUser(HttpServletRequest request, HttpServletResponse response)
			throws BusinessException, ServletException, IOException {
		HttpSession session = request.getSession(false);

		User user1 = (User) session.getAttribute("user");
		LoginService service = new LoginServiceImpl();

		RequestDispatcher requestDispatcher = null;

		String selection = "deposit";

		session.setAttribute("selection", selection);

		requestDispatcher = request.getRequestDispatcher("WithdrawTransferDepo.jsp");
		requestDispatcher.forward(request, response);
	}

	private void withdrawUserResponse(HttpServletRequest request, HttpServletResponse response)
			throws BusinessException, ServletException, IOException {

		HttpSession session = request.getSession(false);

		User user1 = (User) session.getAttribute("user");
		String status = (String) session.getAttribute("status");

		request.setAttribute("status", status);

		System.out.println("Inside withdrawUserResponse1");

		LoginService service = new LoginServiceImpl();

		System.out.println("Inside withdrawUserResponse2");

		double amount = Double.parseDouble(request.getParameter("amount"));
		// RequestDispatcher requestDispatcher = null;


		service.withdrawlFromAccount(user1.getAccount().getAccountId(), amount);
		session.setAttribute("user", user1);
		user1.getRole();
		request.setAttribute("user", user1);
		String status2 = user1.getRole();
		session.setAttribute("status", status2);
		

		RequestDispatcher requestDispatcher = null;
	

			if (true) {
				// success

				requestDispatcher = request.getRequestDispatcher("Main.jsp");
				requestDispatcher.forward(request, response);
			}
 
	}

	private void withdrawUser(HttpServletRequest request, HttpServletResponse response)
			throws BusinessException, ServletException, IOException {
		HttpSession session = request.getSession(false);

		User user1 = (User) session.getAttribute("user");

		RequestDispatcher requestDispatcher = null;

		String selection = "withdraw";

		session.setAttribute("selection", selection);

		requestDispatcher = request.getRequestDispatcher("WithdrawTransferDepo.jsp");
		requestDispatcher.forward(request, response);

	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		Account acc = new Account();
		HttpSession session = request.getSession(false);
		LoginService service = new LoginServiceImpl();

		User user1 = (User) session.getAttribute("user");
		
//		session.setAttribute("oldUser", user1);
//
//		request.setAttribute("oldUser", user1);
//		

		RequestDispatcher requestDispatcher = null;
		PrintWriter out = response.getWriter();
		try {
			if (service.isValidUserCredentials(user)) {
				// success

				requestDispatcher = request.getRequestDispatcher("UpdateCreate.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (BusinessException e) {
			// failure
			requestDispatcher = request.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>" + e.getMessage() + "</span></center>");
		}
		
		
		

	}

	
	

	private void registerUserResponse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, BusinessException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession(false);
		LoginService service = new LoginServiceImpl();
		User user1 = (User) session.getAttribute("user");
		//User old_User = (User) session.getAttribute("oldUser");
		
		//System.out.println(old_User.getUserName());

		
		user1.setUserName(request.getParameter("userName"));
		user1.setPassword(request.getParameter("password"));
		user1.setFirstName(request.getParameter("firstName"));
		user1.setLastName(request.getParameter("lastName"));
		user1.setEmail(request.getParameter("email"));

		service.updateCustomer(user1.getUserName(), user1.getPassword(),user1.getFirstName(),user1.getLastName(),user1.getEmail(),user1.getUserId());

		
		
		
		String status2 = user1.getRole();
		session.setAttribute("status", status2);
		
		session.setAttribute("user", user1);

		RequestDispatcher requestDispatcher = null;

			if (true) {
				// success

				requestDispatcher = request.getRequestDispatcher("Main.jsp");
				requestDispatcher.forward(request, response);
			}

		
		

	}

	
	
	private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		if(session!=null)
		session.invalidate();
		response.sendRedirect("Login.jsp");

	}

	private void findByUserId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void findByStatusId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void findByAccountId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, BusinessException {

		HttpSession session = request.getSession();

		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		LoginService service = new LoginServiceImpl();

		User user2 = new User();

		user2 = service.getCustomerByContact(user.getUserName());
		System.out.println("Right before the status");

		String status = user2.getRole();

		System.out.println("Role is: " + status);
		
		
		RequestDispatcher requestDispatcher = null;
		PrintWriter out = response.getWriter();
		try {
			if (service.isValidUserCredentials(user)) {
				// success
				session.setAttribute("user", user2);
				request.setAttribute("status", status);
				request.setAttribute("user", user2);
				requestDispatcher = request.getRequestDispatcher("Main.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (BusinessException e) {
			// failure
			requestDispatcher = request.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>" + e.getMessage() + "</span></center>");
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */

}
