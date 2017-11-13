package com.lk.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lk.hibernate.model.Student;
import com.lk.hibernate.model.Teacher;
import com.lk.hibernate.model.ZhiCheng;

public class HibernateOne2OneTest {
	private static SessionFactory sessionfactory = null;
	/*@BeforeClass
	public static void beforeClass() {
		sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterclass() {
		sessionfactory.close();
	}
	@Test
	public void testStudentSave() {
		Student s = new Student();
		s.setName("s1");
		s.setAge(1);

		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	@Test
	public void testTeacherSave() {
		Teacher t = new Teacher();
		t.setName("t5");
		t.setTitle("ÌØÌØ¼¶");
		t.setBirthday(new Date());
		t.setZhicheng(ZhiCheng.A);
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}*/
	
	@Test
	public void testOneToOneSave() {
		
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}

	
}
