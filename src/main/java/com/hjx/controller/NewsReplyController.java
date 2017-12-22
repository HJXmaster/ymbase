package com.hjx.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.entity.NewsReply;
import com.hjx.entity.User;
import com.hjx.service.NewsReplyService;
import com.hjx.tools.Page;

@Controller
public class NewsReplyController {

	@Autowired
	NewsReplyService newsReplyService;
	
	
	@RequestMapping("/getNewsReplyByNewsId.do")
	@ResponseBody
	public List<NewsReply> getNewsReplyByNewsId(Integer newsId,int startOfReview){
		Page page=new Page(startOfReview,newsId);
		page.setNum(2);
		System.out.println(page);
		return newsReplyService.selectNewsReplyByNewsId(page);
	}
	@RequestMapping("/getHotNewsReplyByNewsId.do")
	@ResponseBody
	public List<NewsReply> getHotNewsReplyByNewsId(Integer newsId,int startOfReview){
		Page page=new Page(startOfReview,newsId);
		page.setNum(2);
		System.out.println(page);
		return newsReplyService.selectHotNewsReplyByNewsId(page);
	}
	
	@RequestMapping("/getNewsReplyByReplyId.do")
	@ResponseBody
	public List<NewsReply> getNewsReplyByReplyId(Integer nrReplyId,int startOfReply){
		Page page=new Page(startOfReply,nrReplyId);
		page.setNum(2);
		System.out.println(page);
		return newsReplyService.selectByReplyId(page);
	}
	
	@RequestMapping("/reviewNews.do")
	@ResponseBody
	public Map<String,Object> reviewNews(HttpSession session,Integer nrReplyId,String nrContext,Integer newsId){
		Map<String,Object> map=new HashMap<String,Object>();
		User user=(User)session.getAttribute("user");
		if(user==null){
			map.put("status", false);
			map.put("msg", "未登录！");
			return map;
		}
		NewsReply newsReply=new NewsReply();
		newsReply.setNewsId(newsId);
		newsReply.setNrContext(nrContext);
		newsReply.setNrReplyId(nrReplyId);
		newsReply.setNrUid(user.getUid());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		
		newsReply.setNrTime(formatter.format(calendar.getTime()));
		if(newsReplyService.insertReply(newsReply)==true){
			map.put("status", true);
			map.put("msg", "评论成功！");
			return map;
		}else{
			map.put("status", false);
			map.put("msg", "未知原因，评论失败！");
			return map;
		}
	}
	
	@RequestMapping("/getMyReviews.do")
	@ResponseBody
	public Map<String,Object> getMyReviews(HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		User user=(User)session.getAttribute("user");
		if(user==null){
			map.put("status", false);
			map.put("msg", "未登录！");
			return map;
		}
		
		List<NewsReply> newsReply=newsReplyService.selectByUid(user.getUid());
		map.put("status", true);
		map.put("review",newsReply);
		return map;
		
	}
}
