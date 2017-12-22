package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.News;
import com.hjx.entity.NewsReply;
import com.hjx.tools.Page;
@Repository
public interface NewsReplyMapper {

    int deleteByPrimaryKey(Integer nrId);

    int insertSelective(NewsReply record);

    NewsReply selectByPrimaryKey(Integer nrId);
    
    List<NewsReply> selectNewsReplyByNewsId(Page page);
    List<NewsReply> selectByReplyId(Page page);
    List<NewsReply> selectHotNewsReplyByNewsId(Page page);
    List<NewsReply> selectByUid(String uid);
}
