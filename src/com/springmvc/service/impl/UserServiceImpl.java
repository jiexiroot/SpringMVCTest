package com.springmvc.service.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.mapper.CategoriesMapper;
import com.springmvc.pojo.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	CategoriesMapper categoriesMapper;

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
