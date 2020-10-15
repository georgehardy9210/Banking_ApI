package com.app.bank.welcome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.login.exception.BusinessException;
import com.app.login.model.User;
import com.app.login.service.LoginService;
import com.app.login.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class WelcomeController
 */
public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
//		HttpSession session = request.getSession(false);
		
	//	User user = (User) session.getAttribute("user");
		System.out.println("INSIDE THE WelcomeController");
		
		
//		LoginService temp = new LoginServiceImpl();
//		User user3 = new User();
//		
//		user3.setUserName("eg69");
//		user3.setPassword("root");
//		
//		
//		
//		try {
//			if(temp.isUserEmployee(user3)) {
//				
//				System.out.println("Employee HAS BEEN CONFIRM");
//				
//			}
//		} catch (BusinessException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		HttpSession session = request.getSession();
//		
		User user = new User();
//		
		 user.setUserName(request.getParameter("userName"));
		 user.setPassword(request.getParameter("password"));
		 
		 
//		
////		String name = user.getUserName();
////		String pass = user.getPassword();
////		
////		
////		System.out.println("The Date being entered...");
//		System.out.println("Name: " + name);
//		System.out.println("Pass: " + pass);
		
		
		
		
		
		LoginService service=new LoginServiceImpl();
		RequestDispatcher requestDispatcher=null;
		
		
			try {
				user = service.getCustomerByContact(user.getUserName());
				System.out.println(user);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			session.setAttribute("user", user);
				
			
	

		PrintWriter out=response.getWriter();
		try {
			if(service.isValidUserCredentials(user) && service.isUserAdmin(user)) {
				// success
				requestDispatcher=request.getRequestDispatcher("admin.html");
				requestDispatcher.forward(request, response);
			}
			
			else if(service.isValidUserCredentials(user) && service.isUserEmployee(user)){
				requestDispatcher=request.getRequestDispatcher("employee.html");
				requestDispatcher.forward(request, response);
				
				
			}
			else {
				
				requestDispatcher=request.getRequestDispatcher("user.html");
				requestDispatcher.forward(request, response);

				
				
			}
//			
//			
//			//else if isEmployee
//			//else Display user page with its user selections
//			
//			
//			
//			
		} catch (BusinessException e) {
			//failure
			requestDispatcher=request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
		
		
		
	
		
	}

}
