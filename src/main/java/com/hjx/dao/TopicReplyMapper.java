package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.News;
import com.hjx.entity.NewsReply;
import com.hjx.entity.TopicReply;
import com.hjx.tools.Page;
@Repository
public interface TopicReplyMapper {

    int deleteByPrimaryKey(Integer trId);

    int insertSelective(TopicReply record);

    TopicReply selectByPrimaryKey(Integer trId);
    
    List<TopicReply> selectTopicReplyByTopicId(Page page);
    List<TopicReply> selectByReplyId(Page page);
    List<TopicReply> selectHotTopicReplyByTopicId(Page page);
    List<TopicReply> selectByUid(String uid);
}
