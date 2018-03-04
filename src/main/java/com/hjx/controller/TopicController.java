package com.hjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.service.NewsService;
import com.hjx.service.TopicService;

@Controller
public class TopicController {

	@Autowired
	TopicService topicService;
	
	
	@RequestMapping("/getTopicById.do")
	@ResponseBody
	public Object getTopicById(Integer topicId){
		System.out.println("话题编号："+topicId);
		topicService.incTopicReadNum(topicId);
		return topicService.getByTopicId(topicId);
	}
	
	@RequestMapping("/getTopic.do")
	@ResponseBody
	public Object getTopic(){
		return topicService.select();
	}
}
