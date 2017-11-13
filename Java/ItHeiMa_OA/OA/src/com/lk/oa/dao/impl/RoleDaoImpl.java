package com.lk.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.lk.oa.dao.RoleDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
