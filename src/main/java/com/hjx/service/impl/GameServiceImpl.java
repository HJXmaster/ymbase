package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.GameMapper;
import com.hjx.entity.Game;
import com.hjx.service.GameService;
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameMapper gameMapper;
	
	@Override
	public Game getByGmaeId(Integer gameId) {
		// TODO Auto-generated method stub
		return gameMapper.selectByPrimaryKey(gameId);
	}

	@Override
	public boolean deleteByGameId(Integer gameId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatebySelective(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Game> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
