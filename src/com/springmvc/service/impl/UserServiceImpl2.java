package com.springmvc.service.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.mapper.CategoriesMapper;
import com.springmvc.mapper.UserMapper;
import com.springmvc.pojo.User;
import com.springmvc.service.UserService;
import com.springmvc.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService2")
public class UserServiceImpl2 implements UserService2 {

	@Autowired
	UserMapper userMapper;

	@Override
	public boolean doLogin(String name, String password) {
		return userMapper.dologin(name, password)!=0?true:false;
	}

	@Override
	public boolean doRegister(String name, String password, String nickname, String address, String phone, String mail) {
		User user=new User(name,password,nickname,address,phone,mail);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user",user);
		userMapper.doRegister(map);
		int result=Integer.parseInt(map.get("flag").toString());
		return result!=0?true:false;
	}

}
