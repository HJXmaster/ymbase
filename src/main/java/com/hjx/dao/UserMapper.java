package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.User;
@Repository
public interface UserMapper {

    int deleteByPrimaryKey(String uid);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);
    
    List<User> selectAll();
    
    User selectByidAndPassword(User user);
}
