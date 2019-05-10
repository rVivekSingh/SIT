package com.sit.web;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sit.bean.Student;
import com.sit.hb.HBConnection;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		Student student=new Student();
		student.setsName(req.getParameter("StudentName"));
		student.setFatherName(req.getParameter("FatherName"));
		student.setMobile(req.getParameter("phone"));
		student.setEmail(req.getParameter("email"));
		student.setCity(req.getParameter("City"));
		student.setGenId("");
		String []list = req.getParameterValues("courses");
		String courses="";
		for(String s :list) {
			System.out.println("="+s);
			courses=courses+","+s;
		}
		if(courses.startsWith(",")) {
			courses=courses.substring(1, courses.length()-1);
		}
		System.out.println("courses="+courses);
		student.setCourses(courses);
		System.out.println(student);
		
		SessionFactory factory=HBConnection.getHBFactory();
		Session session=null;
		session=factory.openSession();
		System.out.println(session);
		session.beginTransaction();
		if(session!= null) {
			Object obj=session.save(student);
			Integer i=(Integer)obj;
		}
		 String idNum="";
		 if(student.getId()<10) {
			 idNum="00"+student.getId();
		 }
		 else if(student.getId()>10 && student.getId() < 100) {
			 idNum="0"+student.getId();
		 }
		 else {
			 idNum=""+student.getId();
		 }
			 
		 String genString="sftmt/"+(new Date().getYear()+1900)+"/"+idNum;
		 System.out.println("Id==>"+genString +" ===="+student.getGenId());
		 student.setGenId(genString);
		 
		 if(session!= null) {
			 session.saveOrUpdate(student);	 
		 }
		 session.getTransaction().commit();
		 	Calendar date = Calendar.getInstance();
		    date.setTime(new Date());
		    Format f = new SimpleDateFormat("dd-MMMM-yyyy");
		    String startDate=f.format(date.getTime());
		    System.out.println(f.format(date.getTime()));
		    date.add(Calendar.YEAR,1);
		    String endDate=f.format(date.getTime());
		    
		    System.out.println(f.format(date.getTime()));
 		 
            student.setStartDate(startDate);
            student.setEndDate(endDate);
		    HttpSession sessionHttp=req.getSession();
			sessionHttp.setAttribute("student", student);
		 
			RequestDispatcher rd=req.getRequestDispatcher("successStudent.jsp");
	     	rd.forward(req, res);
	}

}
