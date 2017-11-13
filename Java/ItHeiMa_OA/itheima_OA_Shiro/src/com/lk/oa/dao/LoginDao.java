package com.lk.oa.dao;


import java.util.Map;

import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.User;


public interface LoginDao extends BaseDao<User> {
	//public User authentication(final User user);
	public User queryEntryByProperty(final Map<String, Object> map);
}
