package com.springmvc.service;


public interface UserService2 {
	public boolean doLogin(String name, String password);
	public boolean doRegister(String name,String password,String nickname,String address,String phone,String mail);

}
