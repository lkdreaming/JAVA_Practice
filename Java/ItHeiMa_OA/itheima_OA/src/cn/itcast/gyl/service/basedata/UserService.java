package cn.itcast.gyl.service.basedata;

import java.io.Serializable;
import java.util.Collection;

import cn.itcast.gyl.domain.base.User;

public interface UserService {
	public Collection<User> getAllUser();
	public User getUserByID(Serializable id);
	public void updateUser(User user);
	public void saveUser(User user);
	public void deleteUsers(Serializable[] ids);
}
