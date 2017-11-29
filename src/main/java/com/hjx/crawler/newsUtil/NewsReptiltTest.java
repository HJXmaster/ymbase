package com.hjx.crawler.newsUtil;

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
import com.hjx.entity.News;


public class NewsReptiltTest {
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
	
	private static void insert(News news){
       String sql = "insert into `news` (newsId,newsTitle,newsPublisher,newsPublishTime,newsContext,newsPic) "
       		+ "values(?,?,?,?,?,?)";
       PreparedStatement pstmt;
       try {
           pstmt = (PreparedStatement) conn.prepareStatement(sql);
           pstmt.setInt(1,news.getNewsId());
           pstmt.setString(2, news.getNewsTitle());
           pstmt.setString(3, news.getNewsPublisher());
           pstmt.setString(4, news.getNewsPublishTime());
           pstmt.setString(5, news.getNewsContext());
           pstmt.setString(6, news.getNewsPic());
           int i = pstmt.executeUpdate();
           pstmt.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
	}

	@Test
	public void getDatasByClass() throws IOException {
		int i=2228930;
		String test2="https://voice.hupu.com/nba/";
		Rule rule = new Rule(
				test2+i+".html"
				,null, null,
				"voice-main", Rule.CLASS, Rule.GET);

		
		News news=NewsExtractService.extract(rule);
		while(news!=null){
//			System.out.println(news.getNewsId());
			if(news.getNewsId()==null){
				news.setNewsId(i);
//				System.out.println(news);
				insert(news);
			}
			i++;
			rule.setUrl(test2+i+".html");
			news=NewsExtractService.extract(rule);
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
