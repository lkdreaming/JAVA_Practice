package com.lk.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lk.oa.model.Privilege;
import com.lk.oa.service.PrivilegeService;

public class PrivilegeTest {
	/**
	 * 插入两种类型的数据:
	 *	1.菜单类型的数据
	 * 	2.功能类型的数据
	 */
	@Test
	public void testSavePrivilege_Menuitem() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PrivilegeService privilegeService = (PrivilegeService) ctx.getBean("privilegeService");
		
		
		/**
		 * 个人办公
		 */
		Privilege privilegeItem1 = new Privilege();
		privilegeItem1.setPrivilegeId(1L);
		privilegeItem1.setPid(0L);
		privilegeItem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		privilegeItem1.setName("办公自动化");
		privilegeService.saveEntry(privilegeItem1);
		
		Privilege privilegeItem2 = new Privilege();
		privilegeItem2.setPrivilegeId(2L);
		privilegeItem2.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		privilegeItem2.setName("个人办公");
		privilegeService.saveEntry(privilegeItem2);
			Privilege privilegeItem21 = new Privilege();
			privilegeItem21.setPrivilegeId(11L);
			privilegeItem21.setPid(privilegeItem2.getPrivilegeId());
			privilegeItem21.setIcon("css/images/MenuIcon/FUNC20054.gif");
			privilegeItem21.setName("个人考勤");
			privilegeService.saveEntry(privilegeItem21);
			
			Privilege privilegeItem22 = new Privilege();
			privilegeItem22.setPrivilegeId(12L);
			privilegeItem22.setPid(privilegeItem2.getPrivilegeId());
			privilegeItem22.setIcon("css/images/MenuIcon/FUNC23700.gif");
			privilegeItem22.setName("日程安排");
			privilegeService.saveEntry(privilegeItem22);
			
			Privilege privilegeItem23 = new Privilege();
			privilegeItem23.setPrivilegeId(13L);
			privilegeItem23.setPid(privilegeItem2.getPrivilegeId());
			privilegeItem23.setIcon("css/images/MenuIcon/FUNC20069.gif");
			privilegeItem23.setName("工作计划");
			privilegeService.saveEntry(privilegeItem23);
			
			Privilege privilegeItem24 = new Privilege();
			privilegeItem24.setPrivilegeId(14L);
			privilegeItem24.setPid(privilegeItem2.getPrivilegeId());
			privilegeItem24.setIcon("css/images/MenuIcon/FUNC20056.gif");
			privilegeItem24.setName("工作日记");
			privilegeService.saveEntry(privilegeItem24);
			
			Privilege privilegeItem25 = new Privilege();
			privilegeItem25.setPrivilegeId(15L);
			privilegeItem25.setPid(privilegeItem2.getPrivilegeId());
			privilegeItem25.setIcon("css/images/MenuIcon/time_date.gif");
			privilegeItem25.setName("通讯录");
			privilegeService.saveEntry(privilegeItem25);
			
			
			
		
		
		
		Privilege privilegeItem3 = new Privilege();
		privilegeItem3.setPrivilegeId(3L);
		privilegeItem3.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem3.setIcon("css/images/MenuIcon/FUNC20057.gif");
		privilegeItem3.setName("审批流转");
		privilegeService.saveEntry(privilegeItem3);
		
		Privilege privilegeItem4 = new Privilege();
		privilegeItem4.setPrivilegeId(4L);
		privilegeItem4.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem4.setIcon("css/images/MenuIcon/FUNC20056.gif");
		privilegeItem4.setName("知识管理");
		privilegeService.saveEntry(privilegeItem4);
		
		Privilege privilegeItem5 = new Privilege();
		privilegeItem5.setPrivilegeId(5L);
		privilegeItem5.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem5.setIcon("css/images/MenuIcon/manager.gif");
		privilegeItem5.setName("行政管理");
		privilegeService.saveEntry(privilegeItem5);
		
		Privilege privilegeItem6 = new Privilege();
		privilegeItem6.setPrivilegeId(6L);
		privilegeItem6.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem6.setIcon("css/images/MenuIcon/FUNC20001.gif");
		privilegeItem6.setName("人力资源");
		privilegeService.saveEntry(privilegeItem6);
		
		Privilege privilegeItem7 = new Privilege();
		privilegeItem7.setPrivilegeId(7L);
		privilegeItem7.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem7.setIcon("css/images/MenuIcon/eml.gif");
		privilegeItem7.setName("电子邮件");
		privilegeService.saveEntry(privilegeItem7);
		
		Privilege privilegeItem8 = new Privilege();
		privilegeItem8.setPrivilegeId(8L);
		privilegeItem8.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem8.setIcon("css/images/MenuIcon/FUNC20076.gif");
		privilegeItem8.setName("实用工具");
		privilegeService.saveEntry(privilegeItem8);
		
		Privilege privilegeItem9 = new Privilege();
		privilegeItem9.setPrivilegeId(9L);
		privilegeItem9.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem9.setIcon("css/images/MenuIcon/FUNC20001.gif");
		privilegeItem9.setName("个人设置");
		privilegeService.saveEntry(privilegeItem9);
		
		Privilege privilegeItem10 = new Privilege();
		privilegeItem10.setPrivilegeId(10L);
		privilegeItem10.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem10.setIcon("css/images/MenuIcon/system.gif");
		privilegeItem10.setName("系统管理");
		privilegeService.saveEntry(privilegeItem10);
		
		
		
	}

}
