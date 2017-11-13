package com.lk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.DutyDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.Duty;

@Component("dutyDao")
public class DutyDaoImpl extends BaseDaoImpl<Duty> implements DutyDao {

	@Override
	public List<Duty> getDutiesByUserId(Long userId) {
		/**
		 * 根据得到的userId查询该user中的Duty.
		 */
		List<Duty> allDuties = getALLEntry();
		List<Duty> userDuties = (List<Duty>) getHibernateTemplate().find("from Duty duty inner join fetch duty.users user where user.userId = ?", userId);
		for(Duty DutyAll : allDuties) {
			for(Duty UserDuty : userDuties) {
				if(DutyAll.getDutyId() == UserDuty.getDutyId()) {
					DutyAll.setChecked(true);
				} 
			}
		}
		return allDuties;
	}

}
