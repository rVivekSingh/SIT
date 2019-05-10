package com.sit.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HBConnection {

	static Configuration cfg = null;
	static SessionFactory factory = null;
	static Session session = null;
	static Transaction tx = null;

	static {
		// activate Hibernate Framework
		//cfg = cfg.configure("/com/sit/cfgs/hibernate.cfg.xml");

		// build session factory
		factory = new Configuration().configure("/com/sit/cfgs/hibernate.cfg.xml").buildSessionFactory();
		
	}

	public static SessionFactory getHBFactory() {
		return factory;
	}

}
