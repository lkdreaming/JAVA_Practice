package com.lk.oa.action.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.model.Duty;
import com.lk.oa.service.DutyService;

public class DutyActionTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	DutyService ds = (DutyService) ctx.getBean("dutyService");
	@Test
	public void testshowCheckedNodeTree() {
		List<Duty> duties = new ArrayList<Duty>();
		duties = ds.getDutiesByUserId(8L);
		if(duties != null){
			for(int i = 0; i < duties.size(); i++) {
				Duty duty = duties.get(i);
				System.out.println(duty.getChecked());
			}
		}
		else System.out.println("duties is null");
		
	}

}
