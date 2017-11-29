package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
import com.hjx.entity.Team;
@Repository
public interface TeamService {
	

	Team getByTeamId(Integer teamId);
	
	
    boolean deleteByTeamId(Integer teamId);

    
    boolean  insert(Team Team);


//    boolean  updatebySelective(Team team);


    boolean  update(Team team);
    

    List<Team> selectAll();
}