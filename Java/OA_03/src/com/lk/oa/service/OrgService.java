package com.lk.oa.service;

import java.util.List;

import com.lk.oa.model.Orgnization;

public interface OrgService {
	public void add(Orgnization org, int parentId);
	public void remove(int orgId);
	public void update(Orgnization org);
	public Orgnization get(int orgId);
	public List<Orgnization> loadChildren(int parentId);
	public List<Orgnization> loadAllOrgs();
}
