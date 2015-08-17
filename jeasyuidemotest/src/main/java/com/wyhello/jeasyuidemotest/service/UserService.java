package com.wyhello.jeasyuidemotest.service;

import java.util.List;

import com.wyhello.jeasyuidemotest.pojo.User;

public interface UserService {
	
	
	public List<User> queryAllUser();
	public void addUser(User u);
	public void updateUser(User u);
	public void removeUser(User u);
}
