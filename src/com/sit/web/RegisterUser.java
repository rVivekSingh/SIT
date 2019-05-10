package com.sit.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sit.bean.User;

import com.sit.hb.HBConnection;

public class RegisterUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		System.out.println("RRRRRRRRRRRRRRRRRRQTTTTTTTTTTTTTTTTTTTTRRRRRR");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		User user = new User();
		user.setUser_name(req.getParameter("usrname"));
		user.setPassword(req.getParameter("psw"));
		
		System.out.println(user);
		
		SessionFactory factory=HBConnection.getHBFactory();
		Session session=null;
		session=factory.openSession();
		System.out.println(session);
		session.beginTransaction();
		if(session!= null) {
			System.out.println("NOT NULL");
			Object obj=session.save(user);
			System.out.println("NOT NULL0=>"+obj);
			session.getTransaction().commit();
		}
		RequestDispatcher rd=req.getRequestDispatcher("success.html");
	    rd.forward(req, res);
	}
}
