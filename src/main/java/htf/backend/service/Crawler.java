package htf.backend.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class Crawler {
	static String apikey = "A9CAF26B128DB44DA671FA8334A73CE9"; //국어대사전

	public static void main(String[] args) {
		try {
			System.out.println(naverDustCrawler());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String naverDustCrawler() throws IOException {
		ArrayList<String> resultList = new ArrayList<String>();
		String url;
		Document doc; 
		
		url = "https://weather.naver.com/air/";
		
		doc = Jsoup.connect(url).execute().parse();
		
		Elements relatedwords = doc.select("div.dust_chart");
		
		for(Element e : relatedwords) {
			resultList.add(StringUtils.substringBetween(e.toString(), "</em>", "</span>"));
		}
		return resultList.get(0);
	}
	
	public static ArrayList<String> relatedGoogleCrawler(String input) throws IOException {
		ArrayList<String> resultList = new ArrayList<String>();
		String url;
		Document doc; 
		
		String encoded = URLEncoder.encode(input,"utf-8"); //﻿※
		url = "https://www.google.com/search?q="+encoded;
		
		doc = Jsoup.connect(url).execute().parse();
		
		Elements relatedwords = doc.select("p.nVcaUb");
		
		for(Element e : relatedwords) {
			resultList.add(StringUtils.substringBetween(StringUtils.substringBetween(e.toString(), "\">", "</p>"), "\">", "</a>"));
		}
		log.warn("relatedGoogleCrawler 실행 기록");
		return resultList;
	}
	
	public static ArrayList<HashMap<String, String>> googleImageCrawler(String input) throws IOException {
		ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
		String url;
		Document doc; 
		
		String encoded = URLEncoder.encode(input,"utf-8"); //﻿※
		url = "https://www.google.com/search?q="+ encoded + "&newwindow=1&sxsrf=ALeKk015_AA4LJD6gWU_Az6s8DGuVZZMPA:1609206583430&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjv2ZnWifLtAhUQG6YKHaBCBkUQ_AUoAXoECBMQAw&biw=1247&bih=616";
		
		doc = Jsoup.connect(url).execute().parse();
		
		Elements images = doc.select("img");
		
		for(Element e : images) {
			if(e.toString().startsWith("<img class=\"rg_i Q4LuWd\" src=\"data")) {
			} else {
				HashMap<String, String> minimap = new HashMap<String, String>();
				minimap.put("title", StringUtils.substringBetween(e.toString(), "alt=\"", "\""));
				minimap.put("forFoodsSource", StringUtils.substringBetween(e.toString(), "src=\"", "\""));
				minimap.put("source", e.toString().replace("data-src", "src"));
				resultList.add(minimap);
			}
		}
		resultList.remove(0);
		log.warn("googleImageCrawler 실행 기록");
		return resultList;
	}
	
	public static ArrayList<HashMap<String, String>> naverImageCrawler(String input) throws IOException {
		ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
		String url;
		Document doc; 
		
		String encoded = URLEncoder.encode(input,"utf-8"); //﻿※
		url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=image&query="+ encoded;
		
		doc = Jsoup.connect(url).execute().parse();
		
		Elements relatedwords = doc.select("div.thumb");
		
		for(Element e : relatedwords) {
			HashMap<String, String> minimap = new HashMap<String, String>();
			minimap.put("title", StringUtils.substringBetween(e.toString(), "alt=\"", "\">"));
			minimap.put("source", e.toString());
			resultList.add(minimap);
		}
		resultList.remove(0);
		log.warn("naverImageCrawler 실행 기록");
		return resultList;
	}
}
