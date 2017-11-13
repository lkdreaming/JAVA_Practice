package com.lk.oa.service;

import com.lk.oa.model.Orgnization;

public interface OrgService {
	public void add(Orgnization org, int parentId);
	public void remove(int orgId);
	public void update(Orgnization org);
	public Orgnization get(int orgId);
}
