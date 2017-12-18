package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.NewsMapper;
import com.hjx.dao.TeamMapper;
import com.hjx.entity.News;
import com.hjx.entity.Team;
import com.hjx.service.NewsService;
import com.hjx.service.TeamService;
@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	NewsMapper newsMapper;

	@Override
	public News getByNewsId(Integer newsId) {
		// TODO Auto-generated method stub
		return newsMapper.selectByPrimaryKey(newsId);
	}

	@Override
	public boolean deleteByNewsId(Integer newsId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<News> selectAll() {
		// TODO Auto-generated method stub
		return newsMapper.selectAll();
	}

	@Override
	public boolean incNewsReadNum(int newsId) {
		// TODO Auto-generated method stub
		News news=newsMapper.selectByPrimaryKey(newsId);
		if(news==null)return false;
		news.setNewsReadNum(news.getNewsReadNum()+1);
		return newsMapper.updateByPrimaryKeySelective(news)==0?true:false;
	}
	@Override
	public List<News> select() {
		// TODO Auto-generated method stub
		return newsMapper.select();
	}
}
