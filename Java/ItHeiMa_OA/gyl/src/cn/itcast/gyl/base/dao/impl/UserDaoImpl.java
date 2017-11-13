package cn.itcast.gyl.base.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.gyl.dao.base.impl.BaseDaoImpl;
import cn.itcast.gyl.domain.base.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User>{

}
