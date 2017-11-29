package com.hjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	NewsService newsService;
	
	
	@RequestMapping("/getNewsById.do")
	@ResponseBody
	public Object getNewsById(Integer newsId){
		System.out.println("新闻编号："+newsId);
		return newsService.getByNewsId(newsId);
	}
	
	@RequestMapping("/getNews.do")
	@ResponseBody
	public Object getNews(){
		
		return newsService.selectAll();
	}
}
