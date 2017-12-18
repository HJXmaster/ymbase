package com.hjx.controller;

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
	
	@RequestMapping("/getUserInfo.do")
	@ResponseBody
	public User getUserInfo(String uid){
		return userService.getUserInfo(uid);
	}
}
