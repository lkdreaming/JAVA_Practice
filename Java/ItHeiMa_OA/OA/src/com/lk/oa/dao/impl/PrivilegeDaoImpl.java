package com.lk.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.lk.oa.dao.PrivilegeDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

}
