package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.NewsReplyMapper;
import com.hjx.entity.NewsReply;
import com.hjx.service.NewsReplyService;
@Service
public class NewsReplyServiceImpl implements NewsReplyService{

	@Autowired
	NewsReplyMapper newsReplyMapper;
	
	@Override
	public NewsReply selectByPrimaryKey(Integer nrId) {
		return newsReplyMapper.selectByPrimaryKey(nrId);
	}

	@Override
	public List<NewsReply> selectNewsReplyByNewsId(Integer newsId) {
		return newsReplyMapper.selectNewsReplyByNewsId(newsId);
	}

	@Override
	public List<NewsReply> selectByReplyId(Integer nrReplyId) {
		return newsReplyMapper.selectByReplyId(nrReplyId);
	}

}
