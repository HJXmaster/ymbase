package com.hjx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjx.entity.Team;
import com.hjx.service.GameService;
import com.hjx.service.MatchService;
import com.hjx.service.TeamService;
@Controller
public class MatchController {

	@Autowired
	MatchService matchService;
	@Autowired
	TeamService teamService;
	
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
	
	@RequestMapping("/getRankingList.do")
	@ResponseBody
	public Object getRankingList(){
		Map<String,List> rankingList=new HashMap<String,List>();
		List<Team> eastTeam=new ArrayList<Team>(15);
		List<Team> westTeam=new ArrayList<Team>(15);
		List<Team> teams=teamService.selectAll();
		for(Team team :teams){
			if(team.getTeamRegion().equals("east")){
				eastTeam.add(team);
			}else if(team.getTeamRegion().equals("west")){
				westTeam.add(team);
			}
		}
		eastTeam.sort(new Comparator<Team>() {
			@Override
			public int compare(Team team1, Team team2) {
				double rate1=1.0,rate2=1.0;
				if(team1.getFail()!=0){
					rate1=team1.getWin()*1.0/(team1.getWin()+team1.getFail());
				}
				if(team2.getFail()!=0){
					rate2=team2.getWin()*1.0/(team2.getWin()+team2.getFail());
				}
				if(rate1>rate2)return -1;
				else if(rate1<rate2)return 1;
				else return 0;
			}
		});
		westTeam.sort(new Comparator<Team>() {
			@Override
			public int compare(Team team1, Team team2) {
				double rate1=1.0,rate2=1.0;
				if(team1.getFail()!=0){
					rate1=team1.getWin()*1.0/(team1.getWin()+team1.getFail());
				}
				if(team2.getFail()!=0){
					rate2=team2.getWin()*1.0/(team2.getWin()+team2.getFail());
				}
				if(rate1>rate2)return -1;
				else if(rate1<rate2)return 1;
				else return 0;
			}
		});
		rankingList.put("east", eastTeam);
		rankingList.put("west", westTeam);
		return rankingList;
	}
}
