package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.TopicReplyMapper;
import com.hjx.entity.TopicReply;
import com.hjx.service.TopicReplyService;
import com.hjx.tools.Page;
@Service
public class TopicReplyServiceImpl implements TopicReplyService{

	@Autowired
	TopicReplyMapper topicReplyMapper;
	
	@Override
	public TopicReply selectByPrimaryKey(Integer trId) {
		return topicReplyMapper.selectByPrimaryKey(trId);
	}

	@Override
	public List<TopicReply> selectTopicReplyByTopicId(Page page) {
		return topicReplyMapper.selectTopicReplyByTopicId(page);
	}

	@Override
	public List<TopicReply> selectByReplyId(Page page) {
		return topicReplyMapper.selectByReplyId(page);
	}

	@Override
	public List<TopicReply> selectHotTopicReplyByTopicId(Page page) {
		return topicReplyMapper.selectHotTopicReplyByTopicId(page);
	}

	@Override
	public boolean insertReply(TopicReply topicReply) {
		return topicReplyMapper.insertSelective(topicReply)==0;
	}

	@Override
	public List<TopicReply> selectByUid(String uid) {
		return topicReplyMapper.selectByUid(uid);
	}

}
