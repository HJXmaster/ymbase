package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
import com.hjx.entity.Match;
@Repository
public interface MatchMapper {

    int deleteByPrimaryKey(Integer matchId);

//    int insert(Game record);

    int insertSelective(Match record);

    Match selectByPrimaryKey(Integer matchId);

    int updateByPrimaryKeySelective(Match record);

//    int updateByPrimaryKey(Game record);
    
    List<Match> selectAll();
    
    //获取对应日期的比赛
    List<Match> getMatchByDate(String date);
}
