package com.cja.app.user;

import javax.annotation.Resource;

import com.cja.app.base.BeanTest;
import com.cja.app.base.user.dao.UserDao;
import com.cja.app.base.user.mode.User;

public class UserDaoTest extends BeanTest {
	@Resource(name="userDao")
	private UserDao userDao;
	public void TestAddUser(){
		User user = new User();
		user.setUserName("cja");
		user.setPasswrod("111111");
		user.setUserType("1");
		user.setUserStatus(User.STATUS_ACTIVE);
		userDao.addUser(user);
	}
	public void testGetUser(){
		User user = userDao.getUserByName("cja");
		System.out.println("user name="+user.getUserName());
		System.out.println("user password="+user.getPasswrod());
	}
}
