package com.app.bank.controller;

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
 * Servlet implementation class BankLoginController
 */
public class BankLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		User user = new User();
		
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		
		session.setAttribute("user", user);
		
		
		LoginService service=new LoginServiceImpl();
		RequestDispatcher requestDispatcher=null;
		PrintWriter out=response.getWriter();
		try {
			if(service.isValidUserCredentials(user)) {
				// success
				requestDispatcher=request.getRequestDispatcher("admin.html");
				requestDispatcher.forward(request, response);
			}
		} catch (BusinessException e) {
			//failure
			requestDispatcher=request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
		
		
		// TODO Auto-generated method stub
	
		System.out.println("SUCCESS REWRITING BS");
		
		
		
	}

}
