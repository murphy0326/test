package com.wyhello.jeasyuidemotest.dao;

import java.util.List;
import com.wyhello.jeasyuidemotest.pojo.User;

public interface UserDao {
	public List<User> queryAll();
	public void add(User u);
	public void update(User u);
	public void remove(User u);
}
