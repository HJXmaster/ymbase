package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.News;
import com.hjx.entity.NewsReply;
@Repository
public interface NewsReplyMapper {

    int deleteByPrimaryKey(Integer nrId);

    int insertSelective(NewsReply record);

    NewsReply selectByPrimaryKey(Integer nrId);
    
    List<NewsReply> selectNewsReplyByNewsId(Integer newsId);
    List<NewsReply> selectByReplyId(Integer nrReplyId);
}
