package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.NewsReply;

@Repository
public interface NewsReplyService {

	
    NewsReply selectByPrimaryKey(Integer nrId);
    
    List<NewsReply> selectNewsReplyByNewsId(Integer newsId);
    List<NewsReply> selectByReplyId(Integer nrReplyId);
}
