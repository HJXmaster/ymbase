package com.hjx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.entity.NewsReply;
import com.hjx.service.NewsReplyService;

@Controller
public class NewsReplyController {

	@Autowired
	NewsReplyService newsReplyService;
	
	
	@RequestMapping("/getNewsReplyByNewsId.do")
	@ResponseBody
	public List<NewsReply> getNewsReplyByNewsId(Integer newsId){
		return newsReplyService.selectNewsReplyByNewsId(newsId);
	}
}
