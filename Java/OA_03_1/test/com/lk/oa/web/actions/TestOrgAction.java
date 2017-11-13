package com.lk.oa.web.actions;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.web.actions.OrgAction;
import com.lk.oa.model.Orgnization;

public class TestOrgAction {

	
	@Test
	public void list() throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		OrgAction orgAction = (OrgAction) ctx.getBean("org");
		orgAction.list();
		Iterator<Orgnization> it = orgAction.getOrgs().iterator();
		while(it.hasNext()) {
			Orgnization org = it.next();
			System.out.println(org.getName());
		}
		
		
		
	}

}
