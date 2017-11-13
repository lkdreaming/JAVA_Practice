package com.lk.oa.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lk.oa.model.Privilege;

public class PrivilegeTest {
	/**
	 * 插入两种类型的数据:
	 *	1.菜单类型的数据
	 * 	2.功能类型的数据
	 */
	@Test
	public void testSavePrivilege_Menuitem() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx.getBean("hibernateTemplate");
		
		
		/**
		 * 个人办公
		 */
		Privilege privilegeItem1 = new Privilege();
		privilegeItem1.setPrivilegeId(1L);
		privilegeItem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		privilegeItem1.setName("办公自动化");
		
	}

}
