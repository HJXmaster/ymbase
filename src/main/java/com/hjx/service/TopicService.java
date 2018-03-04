package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
import com.hjx.entity.News;
import com.hjx.entity.Team;
import com.hjx.entity.Topic;
@Repository
public interface TopicService {
	

	Topic getByTopicId(Integer topicId);
	
	
    boolean deleteByTopicId(Integer topicId);

    
    boolean  insert(Topic topic);


//    boolean  updatebySelective(Team team);


    boolean  update(Topic topic);
    

    List<Topic> selectAll();
    List<Topic> select();
    boolean incTopicReadNum(int topicId);
}