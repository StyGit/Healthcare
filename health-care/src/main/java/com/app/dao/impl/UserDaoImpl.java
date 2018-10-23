package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUser(User user) {
		return (Integer)ht.save(user);
	}

	@Override
	public void updateUser(User user) {
		ht.update(user);

	}

	@Override
	public void deleteUser(Integer userId) {
		ht.delete(new User(userId));

	}

	@Override
	public User getOneUser(Integer userId) {
		return ht.get(User.class,userId);
	}

	@Override
	public List<User> getAllUsers() {
		return ht.loadAll(User.class);
		
	}

}
