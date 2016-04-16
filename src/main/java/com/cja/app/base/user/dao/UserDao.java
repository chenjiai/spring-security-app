package com.cja.app.base.user.dao;

import com.cja.app.base.user.mode.User;

public interface UserDao {
	public void addUser(User user);
	public User getUserByName(String UserName);
}
