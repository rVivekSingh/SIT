package com.sit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sit.hb.SaveQuery;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
		//set Content Type
	    resp.setContentType("text/html");
	  
	    String name=req.getParameter("uname").toLowerCase();
	    String pwd=req.getParameter("pwd").toLowerCase();
	    int i=0;
	    System.out.println(name +" === "+pwd);
		//i=SaveQuery.isValidLogin(name, pwd);
	 
	   
	   if(SaveQuery.isValidLogin(name, pwd)) {
		    HttpSession session=req.getSession();
		    session.setAttribute("user", name);
		    RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		    rd.forward(req, resp);
	   }
	   else {
		    RequestDispatcher rd=req.getRequestDispatcher("login.html");
		    rd.forward(req, resp);
	   }
	}//doPost()
}
