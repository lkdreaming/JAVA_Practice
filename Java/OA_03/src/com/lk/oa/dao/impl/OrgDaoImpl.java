package com.lk.oa.dao.impl;

import java.util.Iterator;
import java.util.List;
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
		Orgnization org = this.get(orgId);
		if(org.getChildren().size() > 0) return;
		hibernateTemplate.delete(org);
	}

	public Orgnization get(int orgId) {
		return (Orgnization)hibernateTemplate.get(Orgnization.class, orgId);

	}

	public void save(Orgnization org, int parentId) {
		if(parentId != 0) {
			org.setParent(get(parentId));
		}
		hibernateTemplate.save(org);
	}
	
	public List<Orgnization> loadChildren(int parentId) {
		
			if(parentId == 0) {
				
				return (List<Orgnization>) hibernateTemplate.find("from Orgnization o where o.parent.id is null");
			} else
			return (List<Orgnization>) hibernateTemplate.find("from Orgnization o where o.parent.id = ?", parentId);
			
	}
	
	@Override
	public List<Orgnization> loadAllOrgs() {
		return (List<Orgnization>) hibernateTemplate.find("from Orgnization");
	}
	
	//Ê÷×´ÏÔÊ¾
	/*private void printTree(Orgnization org) {
		Iterator<Orgnization> it = org.getChildren().iterator();
		it.next();
		while(it.hasNext()) {
			Orgnization child = it.next();
			printTree(child);
		}
	}*/

}
