package com.lk.oa.dao.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.lk.oa.dao.OrgDao;
import com.lk.oa.model.Orgnization;

@Component("orgDao")
public class OrgDaoImpl implements OrgDao {
	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void update(Orgnization org) {
		hibernateTemplate.update(org);
	}

	public void delete(int orgId) {
		Orgnization org = get(orgId);
		if(org.getChildren().size() > 0) return;
		hibernateTemplate.delete(org);
	}

	//这里要用hibenateTemplate.get()才不会出现$Proxy错误
	public Orgnization get(int orgId) {
		return (Orgnization)hibernateTemplate.get(Orgnization.class, orgId);

	}

	public void save(Orgnization org, int parentId) {
		if(parentId != 0) {
			org.setParent(get(parentId));
		}
		hibernateTemplate.save(org);
	}

}
