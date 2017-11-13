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
			
			Privilege privilegeItem31 = new Privilege();
			privilegeItem31.setPrivilegeId(16L);
			privilegeItem31.setPid(privilegeItem3.getPrivilegeId());
			privilegeItem31.setIcon("css/images/MenuIcon/manager.gif");
			privilegeItem31.setName("审批流程管理");
			privilegeService.saveEntry(privilegeItem31);
			
			Privilege privilegeItem32 = new Privilege();
			privilegeItem32.setPrivilegeId(17L);
			privilegeItem32.setPid(privilegeItem3.getPrivilegeId());
			privilegeItem32.setIcon("css/images/MenuIcon/formmodel.gif");
			privilegeItem32.setName("表单模板管理");
			privilegeService.saveEntry(privilegeItem32);
			
			Privilege privilegeItem33 = new Privilege();
			privilegeItem33.setPrivilegeId(18L);
			privilegeItem33.setPid(privilegeItem3.getPrivilegeId());
			privilegeItem33.setIcon("css/images/MenuIcon/FUNC241000.gif");
			privilegeItem33.setName("发起申请");
			privilegeService.saveEntry(privilegeItem33);
			
			Privilege privilegeItem34 = new Privilege();
			privilegeItem34.setPrivilegeId(19L);
			privilegeItem34.setPid(privilegeItem3.getPrivilegeId());
			privilegeItem34.setIcon("css/images/MenuIcon/FUNC20029.gif");
			privilegeItem34.setName("审批处理");
			privilegeService.saveEntry(privilegeItem34);
			
			Privilege privilegeItem35 = new Privilege();
			privilegeItem35.setPrivilegeId(20L);
			privilegeItem35.setPid(privilegeItem3.getPrivilegeId());
			privilegeItem35.setIcon("css/images/MenuIcon/FUNC20029.gif");
			privilegeItem35.setName("查询状态");
			privilegeService.saveEntry(privilegeItem35);
		
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
		
			Privilege privilegeItem51 = new Privilege();
			privilegeItem51.setPrivilegeId(21L);
			privilegeItem51.setPid(privilegeItem5.getPrivilegeId());
			privilegeItem51.setIcon("css/images/MenuIcon/FUNC20064.gif");
			privilegeItem51.setName("会议管理");
			privilegeService.saveEntry(privilegeItem51);
			
			Privilege privilegeItem52 = new Privilege();
			privilegeItem52.setPrivilegeId(22L);
			privilegeItem52.setPid(privilegeItem5.getPrivilegeId());
			privilegeItem52.setIcon("css/images/MenuIcon/radio_blue.gif");
			privilegeItem52.setName("车辆管理");
			privilegeService.saveEntry(privilegeItem52);
			
			Privilege privilegeItem53 = new Privilege();
			privilegeItem53.setPrivilegeId(23L);
			privilegeItem53.setPid(privilegeItem5.getPrivilegeId());
			privilegeItem53.setIcon("css/images/MenuIcon/FUNC20070.gif");
			privilegeItem53.setName("资产管理");
			privilegeService.saveEntry(privilegeItem53);
		
		Privilege privilegeItem6 = new Privilege();
		privilegeItem6.setPrivilegeId(6L);
		privilegeItem6.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem6.setIcon("css/images/MenuIcon/FUNC20001.gif");
		privilegeItem6.setName("人力资源");
		privilegeService.saveEntry(privilegeItem6);
		
			Privilege privilegeItem61 = new Privilege();
			privilegeItem61.setPrivilegeId(24L);
			privilegeItem61.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem61.setIcon("css/images/MenuIcon/FUNC20076.gif");
			privilegeItem61.setName("档案管理");
			privilegeService.saveEntry(privilegeItem61);
			
			Privilege privilegeItem62 = new Privilege();
			privilegeItem62.setPrivilegeId(25L);
			privilegeItem62.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem62.setIcon("css/images/MenuIcon/FUNC55000.gif");
			privilegeItem62.setName("培训记录");
			privilegeService.saveEntry(privilegeItem62);
			
			Privilege privilegeItem63 = new Privilege();
			privilegeItem63.setPrivilegeId(26L);
			privilegeItem63.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem63.setIcon("css/images/MenuIcon/FUNC55000.gif");
			privilegeItem63.setName("奖惩记录");
			privilegeService.saveEntry(privilegeItem63);
			
			Privilege privilegeItem64 = new Privilege();
			privilegeItem64.setPrivilegeId(27L);
			privilegeItem64.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem64.setIcon("css/images/MenuIcon/FUNC55000.gif");
			privilegeItem64.setName("职位变更");
			privilegeService.saveEntry(privilegeItem64);
			
			Privilege privilegeItem65 = new Privilege();
			privilegeItem65.setPrivilegeId(28L);
			privilegeItem65.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem65.setIcon("css/images/MenuIcon/FUNC55000.gif");
			privilegeItem65.setName("人事合同");
			privilegeService.saveEntry(privilegeItem65);
			
			Privilege privilegeItem66 = new Privilege();
			privilegeItem66.setPrivilegeId(29L);
			privilegeItem66.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem66.setIcon("css/images/MenuIcon/FUNC20001.gif");
			privilegeItem66.setName("薪酬制度");
			privilegeService.saveEntry(privilegeItem66);
			
			Privilege privilegeItem67 = new Privilege();
			privilegeItem67.setPrivilegeId(30L);
			privilegeItem67.setPid(privilegeItem6.getPrivilegeId());
			privilegeItem67.setIcon("css/images/MenuIcon/FUNC20070.gif");
			privilegeItem67.setName("考勤管理");
			privilegeService.saveEntry(privilegeItem67);
		
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
		
			Privilege privilegeItem81 = new Privilege();
			privilegeItem81.setPrivilegeId(31L);
			privilegeItem81.setPid(privilegeItem8.getPrivilegeId());
			privilegeItem81.setIcon("css/images/MenuIcon/FUNC220000.gif");
			privilegeItem81.setName("车票预订");
			privilegeService.saveEntry(privilegeItem81);
			
			Privilege privilegeItem82 = new Privilege();
			privilegeItem82.setPrivilegeId(32L);
			privilegeItem82.setPid(privilegeItem8.getPrivilegeId());
			privilegeItem82.setIcon("css/images/MenuIcon/search.gif");
			privilegeItem82.setName("GIS查询");
			privilegeService.saveEntry(privilegeItem82);
			
			Privilege privilegeItem83 = new Privilege();
			privilegeItem83.setPrivilegeId(33L);
			privilegeItem83.setPid(privilegeItem8.getPrivilegeId());
			privilegeItem83.setIcon("css/images/MenuIcon/FUNC249000.gif");
			privilegeItem83.setName("邮政编码");
			privilegeService.saveEntry(privilegeItem83);
		
		Privilege privilegeItem9 = new Privilege();
		privilegeItem9.setPrivilegeId(9L);
		privilegeItem9.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem9.setIcon("css/images/MenuIcon/FUNC20001.gif");
		privilegeItem9.setName("个人设置");
		privilegeService.saveEntry(privilegeItem9);
		
			Privilege privilegeItem91 = new Privilege();
			privilegeItem91.setPrivilegeId(34L);
			privilegeItem91.setPid(privilegeItem9.getPrivilegeId());
			privilegeItem91.setIcon("css/images/MenuIcon/FUNC20001.gif");
			privilegeItem91.setName("个人信息");
			privilegeService.saveEntry(privilegeItem91);
			
			Privilege privilegeItem92 = new Privilege();
			privilegeItem92.setPrivilegeId(35L);
			privilegeItem92.setPid(privilegeItem9.getPrivilegeId());
			privilegeItem92.setIcon("css/images/MenuIcon/FUNC241000.gif");
			privilegeItem92.setName("密码修改");
			privilegeService.saveEntry(privilegeItem92);
		
		Privilege privilegeItem10 = new Privilege();
		privilegeItem10.setPrivilegeId(10L);
		privilegeItem10.setPid(privilegeItem1.getPrivilegeId());
		privilegeItem10.setIcon("css/images/MenuIcon/system.gif");
		privilegeItem10.setName("系统管理");
		privilegeService.saveEntry(privilegeItem10);
		
			Privilege privilegeItem101 = new Privilege();
			privilegeItem101.setPrivilegeId(36L);
			privilegeItem101.setPid(privilegeItem10.getPrivilegeId());
			privilegeItem101.setIcon("css/images/MenuIcon/system.gif");
			privilegeItem101.setName("岗位管理");
			privilegeService.saveEntry(privilegeItem101);
				Privilege privilegeItem1011 = new Privilege();
				privilegeItem1011.setPrivilegeId(39L);
				privilegeItem1011.setPid(privilegeItem101.getPrivilegeId());
				privilegeItem1011.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1011.setName("岗位查询");
				privilegeService.saveEntry(privilegeItem1011);
				Privilege privilegeItem1012 = new Privilege();
				privilegeItem1012.setPrivilegeId(40L);
				privilegeItem1012.setPid(privilegeItem101.getPrivilegeId());
				privilegeItem1012.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1012.setName("岗位添加");
				privilegeService.saveEntry(privilegeItem1012);
				Privilege privilegeItem1013 = new Privilege();
				privilegeItem1013.setPrivilegeId(41L);
				privilegeItem1013.setPid(privilegeItem101.getPrivilegeId());
				privilegeItem1013.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1013.setName("岗位修改");
				privilegeService.saveEntry(privilegeItem1013);
				Privilege privilegeItem1014 = new Privilege();
				privilegeItem1014.setPrivilegeId(42L);
				privilegeItem1014.setPid(privilegeItem101.getPrivilegeId());
				privilegeItem1014.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1014.setName("岗位删除");
				privilegeService.saveEntry(privilegeItem1014);
			
			Privilege privilegeItem102 = new Privilege();
			privilegeItem102.setPrivilegeId(37L);
			privilegeItem102.setPid(privilegeItem10.getPrivilegeId());
			privilegeItem102.setIcon("css/images/MenuIcon/system.gif");
			privilegeItem102.setName("部门管理");
			privilegeService.saveEntry(privilegeItem102);
				Privilege privilegeItem1021 = new Privilege();
				privilegeItem1021.setPrivilegeId(43L);
				privilegeItem1021.setPid(privilegeItem102.getPrivilegeId());
				privilegeItem1021.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1021.setName("部门查询");
				privilegeService.saveEntry(privilegeItem1021);
				
				Privilege privilegeItem1022 = new Privilege();
				privilegeItem1022.setPrivilegeId(44L);
				privilegeItem1022.setPid(privilegeItem102.getPrivilegeId());
				privilegeItem1022.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1022.setName("部门添加");
				privilegeService.saveEntry(privilegeItem1022);
				
				Privilege privilegeItem1023 = new Privilege();
				privilegeItem1023.setPrivilegeId(45L);
				privilegeItem1023.setPid(privilegeItem102.getPrivilegeId());
				privilegeItem1023.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1023.setName("部门修改");
				privilegeService.saveEntry(privilegeItem1023);
				
				Privilege privilegeItem1024 = new Privilege();
				privilegeItem1024.setPrivilegeId(46L);
				privilegeItem1024.setPid(privilegeItem102.getPrivilegeId());
				privilegeItem1024.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1024.setName("部门删除");
				privilegeService.saveEntry(privilegeItem1024);
		
			Privilege privilegeItem103 = new Privilege();
			privilegeItem103.setPrivilegeId(38L);
			privilegeItem103.setPid(privilegeItem10.getPrivilegeId());
			privilegeItem103.setIcon("css/images/MenuIcon/system.gif");
			privilegeItem103.setName("用户管理");
				privilegeService.saveEntry(privilegeItem103);
				Privilege privilegeItem1031 = new Privilege();
				privilegeItem1031.setPrivilegeId(47L);
				privilegeItem1031.setPid(privilegeItem103.getPrivilegeId());
				privilegeItem1031.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1031.setName("用户查询");
				privilegeService.saveEntry(privilegeItem1031);
				
				Privilege privilegeItem1032 = new Privilege();
				privilegeItem1032.setPrivilegeId(48L);
				privilegeItem1032.setPid(privilegeItem103.getPrivilegeId());
				privilegeItem1032.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1032.setName("用户添加");
				privilegeService.saveEntry(privilegeItem1032);
				
				Privilege privilegeItem1033 = new Privilege();
				privilegeItem1033.setPrivilegeId(49L);
				privilegeItem1033.setPid(privilegeItem103.getPrivilegeId());
				privilegeItem1033.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1033.setName("用户修改");
				privilegeService.saveEntry(privilegeItem1033);
				
				Privilege privilegeItem1034 = new Privilege();
				privilegeItem1034.setPrivilegeId(50L);
				privilegeItem1034.setPid(privilegeItem103.getPrivilegeId());
				privilegeItem1034.setIcon("css/images/MenuIcon/system.gif");
				privilegeItem1034.setName("用户删除");
				privilegeService.saveEntry(privilegeItem1034);
		
			
	}

}
