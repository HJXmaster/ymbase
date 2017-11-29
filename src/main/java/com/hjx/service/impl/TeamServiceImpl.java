package com.hjx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjx.dao.TeamMapper;
import com.hjx.entity.Team;
import com.hjx.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamMapper teamMapper;
	@Override
	public Team getByTeamId(Integer teamId) {
		// TODO Auto-generated method stub
		return teamMapper.selectByPrimaryKey(teamId);
	}

	@Override
	public boolean deleteByTeamId(Integer teamId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Team Team) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Team team) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Team> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
