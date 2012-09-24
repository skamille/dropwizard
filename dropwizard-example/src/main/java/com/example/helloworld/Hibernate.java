package com.example.helloworld;

import org.hibernate.SessionFactory;

public class Hibernate {
	
	private SessionFactory factory;
	
	
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public SessionFactory getSessionFactory() {
		return factory;
	}

}
