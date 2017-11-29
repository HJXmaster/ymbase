package com.hjx.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjx.entity.Game;
import com.hjx.entity.News;
import com.hjx.entity.Team;
@Repository
public interface NewsService {
	

	News getByNewsId(Integer newsId);
	
	
    boolean deleteByNewsId(Integer newsId);

    
    boolean  insert(News news);


//    boolean  updatebySelective(Team team);


    boolean  update(News news);
    

    List<News> selectAll();
}