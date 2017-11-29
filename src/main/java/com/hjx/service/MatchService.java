package com.hjx.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
import com.hjx.entity.Match;
import com.hjx.entity.Team;
@Repository
public interface MatchService {
	

	Match getByMatchId(Integer matchId);
	
	
    boolean deleteByMatchId(Integer matchId);

    
    boolean  insert(Match match);


//    boolean  updatebySelective(Team team);


    boolean  update(Match match);
    

    List<Match> selectAll();
    
    List<Match> getMatchByDate(String date);
    
    Map<String,List<Match>> getWeekMatch(String date);
    List<Match> getTodayMatch();
}