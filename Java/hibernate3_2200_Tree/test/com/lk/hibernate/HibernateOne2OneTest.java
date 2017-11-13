package com.lk.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lk.hibernate.model.Org;


public class HibernateOne2OneTest {
private static SessionFactory sessionFactory;
@BeforeClass
	public static void beforeClass() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterclass() {
		sessionFactory.close();
	}
	/*	
	@Test
	public void testSaveUser() {
		User u = new User();
		u.setName("u1");
		Group g = new Group();
		g.setName("g1");
		u.setGroup(g);
		Session s = sessionFactory.getCurrentSession();
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
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		s.save(g);
		//s.save(u);
		s.getTransaction().commit();
	}
	*/
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
		t.setTitle("���ؼ�");
		t.setBirthday(new Date());
		t.setZhicheng(ZhiCheng.A);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}*/
	
	@Test
	public void testSaveOrgs() {
		Org o = new Org();
		o.setName("�ܹ�˾");
		Org o1 = new Org();
		o1.setName("�ֹ�˾1");
		Org o2 = new Org();
		o2.setName("�ֹ�˾2");
		Org o11 = new Org();
		o11.setName("�ֹ�˾1�µĲ���1");
		Org o12 = new Org();
		o12.setName("�ֹ�˾1�µĲ���2");
		
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.setParent(o);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o2.setParent(o);
		o11.setParent(o1);
		o12.setParent(o1);
		
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(o);
		s.getTransaction().commit();
		s.close();
	}
	
	@Test
	public void testLoad() {
		testSaveOrgs();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Org o = (Org)session.load(Org.class, 1);
		printTree(o, 0);
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	private void printTree(Org o, int level) {
		String preStr = "";
		for(int i = 0; i < level; i++) {
			preStr += "----";
		}
			
		System.out.println(preStr + o.getName());
		for(Org child : o.getChildren()) {
			printTree(child, level+1);
		}
	}
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	public static void main(String[] args) {
		beforeClass();
	}

	
}