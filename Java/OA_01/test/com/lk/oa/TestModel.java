package com.lk.oa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.model.Orgnization;
import com.lk.oa.model.Person;
import com.lk.oa.service.OrgService;

public class TestModel {
	
/*	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		new SchemaExport(new Configuration().configure()).create(false, true);
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}*/
	private static OrgService orgService;

	@Test
	public void testSaveOrg() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		orgService = (OrgService) ctx.getBean("orgService");
		Orgnization org = new Orgnization();
		org.setName("org");
		Orgnization org1 = new Orgnization();
		org1.setName("org1");
		Orgnization org11 = new Orgnization();
		org11.setName("org11");
		Orgnization org12 = new Orgnization();
		org12.setName("org12");
		Orgnization org2 = new Orgnization();
		org2.setName("org2");
		Person p = new Person();
		p.setName("p11");
		p.setOrg(org11);

		org.getChildren().add(org1);
		org.getChildren().add(org2);
		
		org2.setParent(org);
		
		org1.setParent(org);
		org1.getChildren().add(org11);
		org11.setParent(org1);
		
		org1.getChildren().add(org12);
		org12.setParent(org1);
		orgService.add(org,0);
	}
	
	@Test
	public void TestParentChildren() {
		testSaveOrg();
		
		Orgnization org = orgService.get(1);
		System.out.println(org.getName());

		Set<Orgnization> children = new HashSet<Orgnization>();
		children = org.getChildren();
		Iterator<Orgnization> it = children.iterator();
		while(it.hasNext()) {
			Orgnization orgChild = new Orgnization();
			orgChild = it.next();
			System.out.println(orgChild.getName());
		}
	}
	
	@Test
	public void TestChildrenParent() {
		testSaveOrg();
		Orgnization org = orgService.get(5);
		Orgnization orgParent = org.getParent();
		System.out.println(orgParent.getName() + "," + orgParent.getParent().getName());
		
		
	}
	
	

}