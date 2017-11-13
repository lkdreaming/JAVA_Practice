package com.lk.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lk.hibernate.model.Group;
import com.lk.hibernate.model.User;


public class HibernateOne2OneTest {
	private static SessionFactory sessionfactory = null;
	@BeforeClass
	public static void beforeClass() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterclass() {
		sessionfactory.close();
	}
	
	@Test
	public void testSaveUser() {
		User u = new User();
		u.setName("u1");
		Group g = new Group();
		g.setName("g1");
		u.setGroup(g);
		Session s = sessionfactory.getCurrentSession();
		s.beginTransaction();
		//s.save(g);
		s.save(u);
		s.getTransaction().commit();
	}
	
	@Test
	public void testSaveGroup() {
		User u1 = new User();
		User u2 = new User();
		u1.setName("u1");
		u2.setName("u2");
		Group g = new Group();
		g.getUsers().add(u1);
		g.getUsers().add(u2);
		g.setName("g1");
		u1.setGroup(g);
		u2.setGroup(g);
		Session s = sessionfactory.getCurrentSession();
		s.beginTransaction();
		s.save(g);
		//s.save(u);
		s.getTransaction().commit();
	}
	
	/*@Test
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
	}*/
	/*@Test
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
	
	/*@Test
	public void testOneToOneSave() {
		
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}*/

	
}
