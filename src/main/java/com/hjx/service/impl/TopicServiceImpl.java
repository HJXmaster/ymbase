package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.TopicMapper;
import com.hjx.entity.News;
import com.hjx.entity.Topic;
import com.hjx.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicMapper topicMapper;
	@Override
	public Topic getByTopicId(Integer topicId) {
		return topicMapper.selectByPrimaryKey(topicId);
	}

	@Override
	public boolean deleteByTopicId(Integer topicId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Topic topic) {
		// TODO Auto-generated method stub
		return topicMapper.insertSelective(topic)==0;
	}

	@Override
	public boolean update(Topic topic) {
		// TODO Auto-generated method stub
		return topicMapper.updateByPrimaryKeySelective(topic)==0;
	}

	@Override
	public List<Topic> selectAll() {
		// TODO Auto-generated method stub
		return topicMapper.selectAll();
	}

	@Override
	public List<Topic> select() {
		// TODO Auto-generated method stub
		return topicMapper.select();
	}

	@Override
	public boolean incTopicReadNum(int topicId) {
		Topic topic=topicMapper.selectByPrimaryKey(topicId);;
		if(topic==null)return false;
		topic.setTopicReadNum(topic.getTopicReadNum()+1);
		return topicMapper.updateByPrimaryKeySelective(topic)==0;
	}

}
