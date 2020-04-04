package com.spirngmvc.service;


public interface UserService {
	public boolean dologin(String name, String password);
	public boolean doregister(String name,String password,String nickname,String adress,String phone,String mail);
}
