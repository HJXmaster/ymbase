package com.hjx.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.MatchMapper;
import com.hjx.dao.NewsMapper;
import com.hjx.entity.Match;
import com.hjx.entity.Team;
import com.hjx.service.MatchService;
import com.hjx.service.TeamService;
@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	MatchMapper matchMapper;

	@Override
	public Match getByMatchId(Integer matchId) {
		// TODO Auto-generated method stub
		return matchMapper.selectByPrimaryKey(matchId);
	}

	@Override
	public boolean deleteByMatchId(Integer matchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Match match) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Match match) {
		// TODO Auto-generated method stub
		return matchMapper.updateByPrimaryKeySelective(match)==0?true:false;
	}

	@Override
	public List<Match> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Match> getMatchByDate(String date) {
		// TODO Auto-generated method stub
		return matchMapper.getMatchByDate(date);
	}

	@Override
	public List<Match> getTodayMatch() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String today=formatter.format(date);
		return matchMapper.getMatchByDate(today);
	}

	@Override
	public Map<String,List<Match>> getWeekMatch(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fm = new SimpleDateFormat("MM-dd");
		Calendar calendar=Calendar.getInstance();
		try {
			calendar.setTime(formatter.parse(date));
			calendar.add(Calendar.DATE, -3);
			formatter.format(calendar.getTime());
			Map<String,List<Match>> weekMatch=new HashMap<String,List<Match>>();
			for(int i=0;i<7;i++){
				String day=formatter.format(calendar.getTime());
				List<Match> matchs=matchMapper.getMatchByDate(day);
				weekMatch.put(fm.format(calendar.getTime()), matchs);
				calendar.add(Calendar.DATE, 1);
			}
			return weekMatch;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
