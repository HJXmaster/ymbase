package com.hjx.controller;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class GameController {

	Map map=new TreeMap<String, String>();
	@RequestMapping("/getDm.do")
	@ResponseBody
	public Object getDm(String path,String s,String nt){
		System.out.println(System.currentTimeMillis());
		map.put(System.currentTimeMillis(), s);
		System.out.println("文件路径"+path+"弹幕："+s+"nt:"+nt);
		Map map=new HashMap<String, String[]>();
		String[] dm={"hello","I am OK","打火机"};
		map.put("ckplayer", dm);
		return map;
	}
}
