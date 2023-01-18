package com.furkancitilci.utilty;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.furkancitilci.entity.Ogrenci;

public class HibernateUtil {
	
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		
		if( sessionFactory == null) {
			
			try {
				
				
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL,"jdbc:postgresql://localhost:5432/dbmavera");
				settings.put(Environment.USER,"postgres");
				settings.put(Environment.PASS,"9896");
				
				
				settings.put(Environment.HBM2DDL_AUTO, "update");	
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.FORMAT_SQL, "true");
				
				configuration.setProperties(settings);
				
				
				configuration.addAnnotatedClass(Ogrenci.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
					
				
				
			} catch (Exception e) {
				
			}
			
			
			
		}
		
		return sessionFactory;
		
	}
	

}
