package com.spirngmvc.service.impl;

import com.spirngmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngmvc.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean dologin(String name, String password) {
		return userDao.dologin(name, password);
	}

	@Override
	public boolean doregister(String name, String password, String nickname, String adress, String phone, String mail) {
		return userDao.doregister(name,password,nickname,adress,phone,mail);
	}

}
