package com.hjx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.UserMapper;
import com.hjx.entity.User;
import com.hjx.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUserInfo(String uid) {
		
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public User selectByIdAndPassword(String uid, String upassword) {
		User user=new User();
		user.setUid(uid);
		user.setUphone(uid);
		user.setUemail(uid);
		user.setUpassword(upassword);
		return userMapper.selectByidAndPassword(user);
	}

}
