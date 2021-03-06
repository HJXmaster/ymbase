package com.hjx.crawler.newsUtil;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.hjx.crawler.*;
import com.hjx.entity.Match;
import com.hjx.entity.News;


/** 
 *  
 * @author hjx 
 *  
 */  
public class NewsExtractService  
{  
    /** 
     * @param rule 
     * @return 
     */  
    public static News extract(Rule rule)  
    {  
  
        // 进行对rule的必要校验  
        validateRule(rule);  
  
        List<LinkTypeData> datas = new ArrayList<LinkTypeData>();  
        LinkTypeData data = null;  
        try  
        {  
            /** 
             * 解析rule 
             */  
            String url = rule.getUrl();  
            String[] params = rule.getParams();  
            String[] values = rule.getValues();  
            String resultTagName = rule.getResultTagName();  
            int type = rule.getType();  
            int requestType = rule.getRequestMoethod();  
  
            Connection conn = Jsoup.connect(url).ignoreContentType(true);  
            // 设置查询参数  
  
            if (params != null)  
            {  
                for (int i = 0; i < params.length; i++)  
                {  
                    conn.data(params[i], values[i]);  
                }  
            }  
  
            // 设置请求类型  
            Document doc = null;  
            switch (requestType)  
            {  
            case Rule.GET:  
                doc = conn.timeout(100000).maxBodySize(0).get();  
                break;  
            case Rule.POST:  
                doc = conn.timeout(100000).post();  
                break;  
            }  
//            System.out.println(doc.baseUri());
            if(!doc.baseUri().contains("nba")){
            	News n=new News();
            	n.setNewsId(-1);
            	return n;
            }
//            System.out.println(doc.html());
            //处理返回数据  
            Elements results = new Elements();  
            switch (type)  
            {  
            case Rule.CLASS:  
                results = doc.getElementsByClass(resultTagName);  
                break;  
            case Rule.ID:  
                Element result = doc.getElementById(resultTagName);  
                results.add(result);  
                break;  
            case Rule.SELECTION:  
                results = doc.select(resultTagName);  
                break;  
            default:  
                //当resultTagName为空时默认去body标签  
                if (TextUtil.isEmpty(resultTagName))  
                {  
                    results = doc.getElementsByTag("body");  
                }  
            }
            
            News news=new News();
//            System.out.println(results);
//            System.out.println("标题："+results.select("h1").text());
//            System.out.println("来源："+results.select("a").get(0).text());
//            System.out.println("时间："+results.select("a").get(1).text());
//            System.out.println("正文："+doc.getElementsByClass("artical-main-content").html());
//            System.out.println("配图："+results.select("img").get(0).attr("src"));
            news.setNewsTitle(results.select("h1").text());
            news.setNewsPublisher(results.select("a").get(0).text());
            news.setNewsPublishTime(results.select("a").get(1).text());
            news.setNewsContext(doc.getElementsByClass("artical-main-content").html());
            news.setNewsPic(results.select("img").get(0).attr("src"));
            return news;
        } catch (IOException e)  
        {  
            e.printStackTrace();  
        }
		return null;  
   
    }
    
    
	public static List<Match> testJson(String json){
		System.out.println("json格式数据解析开始：");
		JsonParser parser=new JsonParser();  //创建JSON解析器
        JsonObject object=(JsonObject) parser.parse(json);  //创建JsonObject对象

        System.out.println("json格式数据："+object.get("data").getAsJsonObject().entrySet().iterator());
        Iterator<Entry<String, JsonElement>> it=object.get("data").getAsJsonObject().entrySet().iterator();
//        JsonArray array=object.get("data").getAsJsonArray();    //得到为json的数组
        List<Match> matchs=new ArrayList<Match>();
        while(it.hasNext()){
        	System.out.println("---------------");
        	JsonArray array=it.next().getValue().getAsJsonArray();
        	for(int i=0;i<array.size();i++){
        		System.out.print("比赛"+i);
        		JsonObject value=array.get(i).getAsJsonObject();
	        	System.out.println(value);
	        	Match match=new Match();
	        	match.setMatchDesc(value.get("matchDesc").getAsString());
	        	match.setLeftId(value.get("leftId").getAsInt());
	        	match.setLeftGoal(value.get("leftGoal").getAsInt());
	        	match.setRightId(value.get("rightId").getAsInt());
	        	match.setRightGoal(value.get("rightGoal").getAsInt());
	        	match.setStartTime(value.get("startTime").getAsString());
	        	match.setQuarter(value.get("quarter").getAsString());
	        	match.setQuarterTime(value.get("quarterTime").getAsString());
	        	System.out.println(match);
	        	matchs.add(match);
        	}
        }
//        for(int i=0;i<array.size();i++){
//            System.out.println("---------------");
//            JsonObject subObject=array.get(i).getAsJsonObject();
//            Movie movie=new Movie();
//            movie.setId(subObject.get("id").getAsString());
//            movie.setRate(subObject.get("rate").getAsFloat());
//            movie.setTitle(subObject.get("title").getAsString());
//            movie.setUrl(subObject.get("url").getAsString());
//            movie.setStar(subObject.get("star").getAsInt());
////            System.out.println(movie);
//        }
//        System.out.println(array.toString());
//        Gson gson=new Gson();
//        List<Movie> movies=gson.fromJson(array.toString(), new TypeToken<List<Movie>>() {}.getType());
//        for(Movie mov:movies){
//        	System.out.println(mov);
//        }
//        return movies;
        return matchs;
	}
  
    /** 
     * 对传入的参数进行必要的校验 
     */  
    private static void validateRule(Rule rule)  
    {  
        String url = rule.getUrl();  
        if (TextUtil.isEmpty(url))  
        {  
            throw new RuleException("url不能为空！");  
        }  
        if (!url.startsWith("http://")&&!url.startsWith("https://"))  
        {  
            throw new RuleException("url的格式不正确！");  
        }  
  
        if (rule.getParams() != null && rule.getValues() != null)  
        {  
            if (rule.getParams().length != rule.getValues().length)  
            {  
                throw new RuleException("参数的键值对个数不匹配！");  
            }  
        }  
  
    }  
  
  
}  
