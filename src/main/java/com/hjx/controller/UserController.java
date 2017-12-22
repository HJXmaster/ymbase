package com.hjx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.entity.User;
import com.hjx.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUserInfoById.do")
	@ResponseBody
	public User getUserInfoById(String uid){
		return userService.getUserInfo(uid);
	}
	
	@RequestMapping("/loginUser.do")
	@ResponseBody
	public Map<String,Object> loginUser(String uid,String upassword,HttpSession session){
		System.out.println("login"+session);
		User user= userService.selectByIdAndPassword(uid, upassword);
		Map map=new HashMap<String,Object>();
		if(user!=null){
			user.setUanswer(null);
			user.setUpassword(null);
			user.setUquestion(null);
			session.setAttribute("user", user);
			System.out.println(user);
			map.put("status", true);
			map.put("msg", "登录成功!");
			map.put("user", user);
			return map;
		}else {
			map.put("status", false);
			map.put("msg", "密码错误!");
			return map; 
		}
	}
	
	@RequestMapping("/getUserInfo.do")
	@ResponseBody
	public Map<String,Object> getUserInfo(HttpSession session){
		System.out.println("userinfo"+session);
		Map map=new HashMap<String,Object>();
		User user=(User)session.getAttribute("user");
		System.out.println(session.getAttribute("user"));
		if(user!=null){
			map.put("status", true);
			map.put("user", user);
			return map;
		}else {
			map.put("status", false);
			map.put("msg", "已下线!");
			return map; 
		}
	}
}
