package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.NewsReply;
import com.hjx.entity.TopicReply;
import com.hjx.tools.Page;

@Repository
public interface TopicReplyService {

	
    TopicReply selectByPrimaryKey(Integer trId);
    
    List<TopicReply> selectTopicReplyByTopicId(Page page);
    List<TopicReply> selectByReplyId(Page page);
    List<TopicReply> selectHotTopicReplyByTopicId(Page page);
    
    boolean insertReply(TopicReply topicReply);
    
    List<TopicReply> selectByUid(String uid);
}
