package com.hjx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.News;
@Repository
public interface NewsMapper {

    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

//    int updateByPrimaryKey(Team record);
    
    List<News> selectAll();
    List<News> select();
}
