package com.lk.hibernate5Annotation.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lk.hibernate5Annotation.model.Event;


public class TestTransation {
	private static EntityManagerFactory entityManagerFactory ;
	
	@BeforeClass
	public static void beforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}
	
	@AfterClass
	public static void afterClass() {
		entityManagerFactory.close();
	}

	@Test
	public void test() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist( new Event( "Our very first event!", new Date() ) );
		em.persist( new Event( "A follow up event", new Date() ) );
		em.getTransaction().commit();
		em.close();
	}

}
