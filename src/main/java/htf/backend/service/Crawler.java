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
	public static void main(String[] args) throws IOException {
		System.out.println(naverHumidtyCrawler());
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
	
	public static String naverTempCrawler() throws IOException {
		ArrayList<String> resultList = new ArrayList<String>();
		String url;
		Document doc; 
		
		url = "https://weather.naver.com/";
		
		doc = Jsoup.connect(url).execute().parse();
		
		Elements relatedwords = doc.select("strong.current");
		
		for(Element e : relatedwords) {
			resultList.add(StringUtils.substringBetween(e.toString(), "</span>", "<span class"));
		}
		return resultList.get(0);
	}

	public static String naverHumidtyCrawler() throws IOException {
		ArrayList<String> resultList = new ArrayList<String>();
		String url;
		Document doc; 
		
		url = "https://weather.naver.com/";
		
		doc = Jsoup.connect(url).execute().parse();
		
		Elements relatedwords = doc.select("dd.desc");
		
		for(Element e : relatedwords) {
			resultList.add(StringUtils.substringBetween(e.toString(), "desc\">", "</dd"));
		}
		return resultList.get(0);
	}
}
