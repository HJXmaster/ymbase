package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.News;
import com.hjx.entity.Topic;
@Repository
public interface TopicMapper {

    int deleteByPrimaryKey(Integer topicId);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer topicId);

    int updateByPrimaryKeySelective(Topic record);

//    int updateByPrimaryKey(Team record);
    
    List<Topic> selectAll();
    List<Topic> select();
}
