package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
import com.hjx.entity.Team;
@Repository
public interface TeamMapper {

    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer teamId);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
    
    List<Team> selectAll();
}
