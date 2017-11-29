package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
@Repository
public interface GameService {
	

	Game getByGmaeId(Integer gameId);
	
	
    boolean deleteByGameId(Integer gameId);

    
    boolean  insert(Game game);


    boolean  updatebySelective(Game game);


    boolean  update(Game game);
    

    List<Game> selectAll();
}