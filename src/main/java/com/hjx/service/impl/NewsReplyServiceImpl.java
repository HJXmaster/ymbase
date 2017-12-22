package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.NewsReplyMapper;
import com.hjx.entity.NewsReply;
import com.hjx.service.NewsReplyService;
import com.hjx.tools.Page;
@Service
public class NewsReplyServiceImpl implements NewsReplyService{

	@Autowired
	NewsReplyMapper newsReplyMapper;
	
	@Override
	public NewsReply selectByPrimaryKey(Integer nrId) {
		return newsReplyMapper.selectByPrimaryKey(nrId);
	}

	@Override
	public List<NewsReply> selectNewsReplyByNewsId(Page page) {
		return newsReplyMapper.selectNewsReplyByNewsId(page);
	}

	@Override
	public List<NewsReply> selectByReplyId(Page page) {
		return newsReplyMapper.selectByReplyId(page);
	}

	@Override
	public List<NewsReply> selectHotNewsReplyByNewsId(Page page) {
		
		return newsReplyMapper.selectHotNewsReplyByNewsId(page);
	}

	@Override
	public boolean insertReply(NewsReply newsReply) {
		return newsReplyMapper.insertSelective(newsReply)==1?true:false;
	}

	@Override
	public List<NewsReply> selectByUid(String uid) {
		return newsReplyMapper.selectByUid(uid);
	}

}
