package com.lk.oa.action.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.action.UserAction;
import com.lk.oa.model.Department;
import com.lk.oa.model.Duty;
import com.lk.oa.model.User;
import com.opensymphony.xwork2.ActionContext;

public class UserActionTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	UserAction userAction = (UserAction) ctx.getBean("userAction");
	@Test
	public void testUpdateUI() {
		User user = userAction.getUserService().getEntryById(1L);
		userAction.setDepartmentId(user.getDepartment().getDepartmentId());
		int index = 0;
		for(Duty duty : user.getDuties()) {
			System.out.println(duty.getName());
			index ++;
		}
		/*Iterator<Duty> it = user.getDuties().iterator();
		it.hasNext();
		while(it.hasNext()) {
			Duty duty = it.next();
			dutyIds[index] = duty.getDutyId();
			index++;
		}*/
		List<Department> departments = userAction.getDepartmentService().getALLEntry();
		List<Duty> duties = userAction.getDutyService().getALLEntry();
		ActionContext.getContext().put("departments", departments);
		ActionContext.getContext().put("duties", duties);	
	}

}
