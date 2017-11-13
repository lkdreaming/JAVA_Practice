package com.lk.oa.dao;

import java.util.List;

import com.lk.oa.model.Orgnization;

public interface OrgDao {

	void update(Orgnization org);

	void delete(int orgId);

	Orgnization get(int orgId);

	void save(Orgnization org, int parentid);
	
	List<Orgnization> loadChildren(int parentId);

	List<Orgnization> loadAllOrgs();

}
