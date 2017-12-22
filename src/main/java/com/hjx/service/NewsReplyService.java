package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.NewsReply;
import com.hjx.tools.Page;

@Repository
public interface NewsReplyService {

	
    NewsReply selectByPrimaryKey(Integer nrId);
    
    List<NewsReply> selectNewsReplyByNewsId(Page page);
    List<NewsReply> selectByReplyId(Page page);
    List<NewsReply> selectHotNewsReplyByNewsId(Page page);
    
    boolean insertReply(NewsReply newsReply);
    
    List<NewsReply> selectByUid(String uid);
}
