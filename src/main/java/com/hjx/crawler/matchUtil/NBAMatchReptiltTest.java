package com.hjx.crawler.matchUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.hjx.crawler.Rule;
import com.hjx.entity.Match;


public class NBAMatchReptiltTest {
	static Connection conn;
	static{
		System.out.println("连接数据库");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/ymbase?characterEncoding=utf8";//数据库连接子协议
			conn=DriverManager.getConnection(url,"root","sr107");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void insert(Match match){
       String sql = "insert into `match` (matchId,matchDesc,leftId,leftGoal,rightId,rightGoal,startTime,quarter,quarterTime,ifEnd) "
       		+ "values(?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement pstmt;
       try {
           pstmt = (PreparedStatement) conn.prepareStatement(sql);
           pstmt.setInt(1, match.getMatchId());
           pstmt.setString(2, match.getMatchDesc());
           pstmt.setInt(3, match.getLeftId());
           pstmt.setInt(4, match.getLeftGoal());
           pstmt.setInt(5, match.getRightId());
           pstmt.setInt(6, match.getRightGoal());
           pstmt.setString(7, match.getStartTime());
           pstmt.setString(8, match.getQuarter());
           pstmt.setString(9, match.getQuarterTime());
           pstmt.setString(10, match.getIfEnd());
           int i = pstmt.executeUpdate();
           pstmt.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	}
	static int i=1;

	@Test
	public void getDatasByClass() throws IOException {
		String test2="http://matchweb.sports.qq.com/kbs/list?from=NBA_PC&columnId=100000&";
		Param param=new Param("2017-10-18", "2017-10-24");
		Rule rule = new Rule(
				test2+param.toString()
				,null, null,
				"", -1, Rule.GET);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date startTime = null;
		Date endTime =null;
		try {
			startTime = formatter.parse("2018-01-16");
			endTime = formatter.parse("2018-01-22");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar=Calendar.getInstance();

		List<Match> matchs=NBAMatchExtractService.extract(rule);
		while(matchs!=null&&!matchs.isEmpty()){
			
			for(Match match:matchs){
				insert(match);
			}
			calendar.setTime(endTime);
			calendar.add(Calendar.DATE, 1);
			startTime=calendar.getTime();
			calendar.add(Calendar.DATE, 6 );
			endTime=calendar.getTime();
			formatter.format(endTime);
			param.setStartTime(formatter.format(startTime));
			param.setEndTime(formatter.format(endTime));
			rule.setUrl(test2+param.toString());
			matchs=NBAMatchExtractService.extract(rule);
		}
		
	}

	
	public void updateTadayMatch() throws IOException {
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
				
			}
			
		}
		
	}

//	public void getDatasByCssQuery() {
//		Rule rule = new Rule("http://www.11315.com/search",
//				new String[] { "name" }, new String[] { "兴网" },
//				"div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
//		List<LinkTypeData> extracts = ExtractService.extract(rule);
//		printf(extracts);
//	}
	
////	@org.junit.Test
//	public void getDatasQuery() {
//		Rule rule = new Rule("https://movie.douban.com/tag",
//				null, null,
//				"", -1, Rule.GET);
//		List<LinkTypeData> extracts = ExtractService.extract(rule);
//		printf(extracts);
//	}
	
	public void testUrlPatten(String linkHref){
		Pattern pattern = Pattern.compile(  
    		"https://movie.douban.com/subject/\\d\\d*",  
            Pattern.CASE_INSENSITIVE);  
		//     创建匹配器  
		Matcher matcher = pattern.matcher(linkHref);  
		if(matcher.find()){
			String str = matcher.group();  
			System.out.println("找到正确的url"+str);
		}
	}
}
