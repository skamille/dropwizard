package com.example.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hibernate {
	
	private SessionFactory factory;
	ThreadLocal<Session> openSession = null;
	
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public SessionFactory getSessionFactory() {
		return factory;
	}

	public synchronized Session openSession() {
		if(openSession == null) {
			openSession = new ThreadLocal<Session>();
			openSession.set(factory.openSession());
		}
		return openSession.get();
	}
	
	public synchronized void closeSession() {
		if(openSession != null) {
			openSession.get().close();
			openSession = null;
		}
	}
	
}
