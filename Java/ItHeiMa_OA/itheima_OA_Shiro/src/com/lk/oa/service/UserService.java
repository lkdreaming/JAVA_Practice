package com.lk.oa.service;

import java.util.List;

import com.lk.oa.model.User;
import com.lk.oa.service.base.BaseService;

public interface UserService extends BaseService<User> {

	List<User> getALLUsers();

}
