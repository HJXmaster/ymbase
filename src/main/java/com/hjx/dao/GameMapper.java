package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
@Repository
public interface GameMapper {

    int deleteByPrimaryKey(Integer gameId);

    int insert(Game record);

    int insertSelective(Game record);

    Game selectByPrimaryKey(Integer gameId);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
    
    List<Game> selectAll();
}
