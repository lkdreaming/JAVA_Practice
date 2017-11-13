package com.lk.spring.registration.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessFactory = null;
	static {
		sessFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessFactory() {
		return sessFactory;
	}
	public static void setSessFactory(SessionFactory sessFactory) {
		HibernateUtil.sessFactory = sessFactory;
	}
}	
