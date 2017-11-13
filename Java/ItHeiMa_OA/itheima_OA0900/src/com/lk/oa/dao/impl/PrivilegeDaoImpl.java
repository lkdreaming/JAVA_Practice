package com.lk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.PrivilegeDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.Privilege;

@Component("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

	@Override
	public List<Privilege> getPrivilegesByDutyId(Long dutyId) {
		List<Privilege> privileges = getALLEntry();
		List<Privilege> dutyPrivileges = (List<Privilege>) getHibernateTemplate().find("from Privilege p inner join fetch p.duties d where d.dutyId = ?", dutyId);
		for(Privilege p : privileges) {
			for(Privilege dp : dutyPrivileges) {
				if(p.getPrivilegeId() == dp.getPrivilegeId()) {
					p.setChecked(true);
				}
			}
		}
		return privileges;
	}

}
