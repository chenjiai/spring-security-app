package com.cja.app.base.user.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.cja.app.base.user.dao.UserDao;
import com.cja.app.base.user.mode.User;
import com.intensoft.dao.hibernate.HibernateGenericDao;

@Service("userDao")
public class UserDaoImpl extends HibernateGenericDao<User, Integer> implements UserDao {

	public void addUser(User user) {
		super.save(user);
	}

	public User getUserByName(String userName) {
		List<User> users = (List<User>) super.find("from "+User.class.getName()+" u where u.userName=? and u.userStatus=?", new Object[]{userName,User.STATUS_ACTIVE});
		if(users!=null&&users.size()>0){
			return users.get(0);
		}else{
			return null;
		}
	}

	@Resource(name = "sessionFactory")
	@Override
	public void setInjectSessionFactory(SessionFactory sessionFactory) {
		 super.setSessionFactory(sessionFactory);
	}

}
