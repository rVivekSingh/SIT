package com.sit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("logout servlet");
		HttpSession session=req.getSession();
		System.out.println(session.getAttribute("user"));
		System.out.println("Logout==");
		System.out.print(session.getAttribute("user"));
		session.removeAttribute("user");
		session.invalidate();
		
		
		
	   resp.sendRedirect("login.html");	
	   
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
