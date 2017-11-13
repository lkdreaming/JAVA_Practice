package com.lk.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.lk.oa.dao.UserDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
