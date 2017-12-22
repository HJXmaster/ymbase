package com.hjx.job;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hjx.crawler.Rule;
import com.hjx.crawler.matchUtil.NBAMatchExtractService;
import com.hjx.crawler.matchUtil.Param;
import com.hjx.entity.Match;
import com.hjx.service.MatchService;
import com.hjx.service.NewsService;

@Component("taskJob")
public class TaskJob {
	@Autowired
	MatchService matchService;
	
	@Scheduled(cron="0 0/1 7,8,9,10,11,12,13,14 * * ?")
    public void job1() {  
        System.out.println("任务进行中。。。");
		String test2="http://matchweb.sports.qq.com/kbs/list?from=NBA_PC&columnId=100000&";
		Param param=new Param("2017-10-18", "2017-10-24");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar=Calendar.getInstance();
		param.setStartTime(formatter.format(calendar.getTime()));
		param.setEndTime(formatter.format(calendar.getTime()));
		System.out.println(param);
		Rule rule = new Rule(
				test2+param.toString()
				,null, null,
				"", -1, Rule.GET);
		List<Match> matchs=NBAMatchExtractService.extract(rule);
		if(matchs!=null&&!matchs.isEmpty()){
			for(Match match:matchs){
				matchService.update(match);
			}
			
		}
	}
        
}
