package com.spirngmvc.controller;


import com.spirngmvc.pojo.User;
import com.spirngmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * UserController为控制器类：
 * 1.接收用户在JSP页面中输入的数据和请求
 * 2.根据请求调用Model的相关方法
 * 3.根据方法返回值，跳转到不同的页面
 * @author GOU
 *
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//请求映射表单中的login方法
	@RequestMapping({"login","/resources/login"})
	public String doLogin(User user, HttpSession session) {
		if(userService.dologin(user.getLoginId(), user.getLoginPwd())) {
			session.setAttribute("username", user.getLoginId());
			System.out.println("登录成功");
			return "index";
		}else {
			return "login";
		}
	}
	//请求映射表单中的register方法
	@RequestMapping("/resources/register")
	public String doRegister(User user, HttpServletRequest request, HttpServletResponse response){
		//当用户没输入值时赋值为空字符串
		if(user.getName()==null) user.setName("");
		if(user.getAddress()==null) user.setAddress("");
		if(user.getPhone()==null) user.setPhone("");
		if(user.getMail()==null) user.setMail("");
		if (userService.doregister(user.getLoginId(),user.getLoginPwd(),user.getName(),user.getAddress(),user.getPhone(),user.getMail())){
			return "login";
		}else{
			return "register2";
		}
	}
	//请求映射ajax中的registerAjax方法
	@RequestMapping("registerAjax")
	@ResponseBody
	public Map<String,String> ajaxRegister(String chooesID,String username,String password,String telphone,String address,String nickname,String mail){
		Map<String,String> resultMap = new HashMap<String, String>();
		if(userService.doregister(username, password, nickname, address, telphone,mail)){
			System.out.println("注册成功");
			resultMap.put("result","1");
		}else{
			resultMap.put("result","0");
		}
		return resultMap;
	}
}
