package com.wyhello.jeasyuidemotest.service.impl;

import java.util.List;

import com.wyhello.jeasyuidemotest.dao.UserDao;
import com.wyhello.jeasyuidemotest.dao.impl.UserDaoImpl;
import com.wyhello.jeasyuidemotest.pojo.User;
import com.wyhello.jeasyuidemotest.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public List<User> queryAllUser() {
		List<User> l = userDao.queryAll();
		return l;
	}

	public void addUser(User u) {
		userDao.add(u);
		
	}
	
	public void updateUser(User u) {
		userDao.update(u);
		
	}

	public void removeUser(User u) {
		userDao.remove(u);
	}

}
