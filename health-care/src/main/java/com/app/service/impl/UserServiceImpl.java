package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	@Transactional
	public Integer saveUser(User user) {
		return dao.saveUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Transactional
	public void deleteUser(Integer userId) {
		dao.deleteUser(userId);
	}

	@Transactional(readOnly = true)
	public User getOneUser(Integer userId) {
		return dao.getOneUser(userId);
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

}
