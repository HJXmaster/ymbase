package com.hjx.service;

import org.springframework.stereotype.Repository;

import com.hjx.entity.User;

@Repository
public interface UserService {

	User getUserInfo(String uid);
	User selectByIdAndPassword(String uid,String upassword);
}
