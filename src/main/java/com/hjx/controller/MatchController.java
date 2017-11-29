package com.hjx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.service.GameService;
import com.hjx.service.MatchService;
@Controller
public class MatchController {

	@Autowired
	MatchService matchService;
	
	@RequestMapping("/getMatchById.do")
	@ResponseBody
	public Object getMatchById(Integer matchId){
		System.out.println("比赛编号："+matchId);
		return matchService.getByMatchId(matchId);
	}
	
	@RequestMapping("/getTodayMatch.do")
	@ResponseBody
	public Object getTodayMatch(){
		return matchService.getTodayMatch();
	}
	
	@RequestMapping("/getWeekMatch.do")
	@ResponseBody
	public Object getWeekMatch(String date){
		System.out.println("日期"+date);
		return matchService.getWeekMatch(date);
	}
}
