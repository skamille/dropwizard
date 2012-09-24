package com.example.helloworld;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Mappings;
import org.skife.jdbi.cglib.asm.ClassAdapter;

import com.yammer.dropwizard.config.Environment;

public class HibernateFactory {
	private final Environment environment;

	public HibernateFactory(Environment environment) {
		this.environment = environment;
	}

	public Hibernate build(HibernateConfiguration config, String name) {
		try {
			Configuration hibConfig = new Configuration();
			for(String classname : config.getEntityClasses()) {
				hibConfig.addAnnotatedClass(Class.forName(classname));
			}
			hibConfig.setProperty("hibernate.dialect", config.getDialect());
			hibConfig.setProperty("hibernate.connection.url", config.getUrl());
			hibConfig.setProperty("hibernate.connection.username", config.getUsername());
			hibConfig.setProperty("hibernate.connection.password", config.getPassword());
			hibConfig.setProperty("hibernate.connection.pool_size", String.valueOf(config.getPoolSize()));
			hibConfig.setProperty("hibernate.hbm2ddl.auto", "create");
			SessionFactory factory = hibConfig.buildSessionFactory();
			Hibernate foo = new Hibernate();
			foo.setSessionFactory(factory);
			return foo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
