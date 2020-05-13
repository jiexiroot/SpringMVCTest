package com.springmvc.pojo;

import java.io.Serializable;

/**
 * 用户POJO
 */
public class User2 implements Serializable {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
	 return "User [username=" + username + ", password=" + password + "]";
	}
}