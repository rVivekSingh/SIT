package com.sit.hb;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.sit.bean.Student;



public class SaveQuery {
	

	public static int validate(String user,String pwd){
		SessionFactory factory=HBConnection.getHBFactory();
		Session session=null;
		session=factory.openSession();
		Query query = session.createQuery("from user where user_name=:user and password:pwd");
		query.setString(1, user);
		query.setString(2, pwd);
		
		
		Criterion uname = Restrictions.eq("user_name",user);
		Criterion upwd = Restrictions.eq("password",pwd);
		
		Criteria cr = session.createCriteria(Student.class);
		LogicalExpression andExp = Restrictions.and(uname, upwd);
		
		cr.add(andExp);

		List results = cr.list();
		System.out.println("LISTT="+results);
		if(results.isEmpty())
			return 0;
		else
			return 1;
		
	}
   
	 public static boolean isValidLogin(String uname, String pass) {
	        int count = 0;
	    	SessionFactory factory=HBConnection.getHBFactory();
			Session session=null;
			session=factory.openSession();
	        String query = "select reg.user_name,reg.password from User as reg where reg.user_name='" + uname + "' and reg.password='" + pass + "'";
	        Query DBquery = session.createQuery(query);
	        for (Iterator it = DBquery.iterate(); it.hasNext();) {            it.next();
	            count++;
	        }
	        System.out.println("Total rows: " + count);
	        if (count == 1) {
	            return true;
	        } else {
	            return false;
	        }
	      } 
	/*	
	@SuppressWarnings("unchecked")
	public static List<ContactUsBean> getAllQueries(){
		SessionFactory factory=HBConnection.getHBFactory();
		Session session=null;
		session=factory.openSession();
		
		
		
		Query query = session.createQuery("from ContactUsBean");
        List<ContactUsBean> list = (List<ContactUsBean>) query.list();
        
        return list;
		
	}*/
	@SuppressWarnings("unchecked")
	public static List<Student> getAllQueries(){
		SessionFactory factory=HBConnection.getHBFactory();
		Session session=null;
		session=factory.openSession();
		
		
		
		Query query = session.createQuery("from Student");
        List<Student> list = (List<Student>) query.list();
        
        return list;
		}
}
