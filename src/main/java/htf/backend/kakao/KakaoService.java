package htf.backend.kakao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;

import htf.backend.service.AdminService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class KakaoService {
	@Autowired
	private AdminService adminService;
	
	String uuidList = "[\"";
	
//	public static void main(String[] args) throws Exception {
		//adId를 통해 token 조회
//		String token = getToken("a2sd");
//		String token = "3A5pxHHuFg-J-ZbF6dAUgkBfKgRE89H5FDXUvQopb7kAAAF3nBWcOA"; //임시
//		JSONObject clientList = getList(token);
//		System.out.println(clientList);
//		sendAlarm(clientList, token);
//	}
	
	private String getToken(String adId) {
		return adminService.findByAdId(adId).getKakaoToken();
	}
	
	public JSONObject getList(String token) throws Exception {
		String url = "https://kapi.kakao.com/v1/api/talk/friends";
		HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
		httpConn.setRequestProperty("Authorization", "Bearer "+token);
		httpConn.setRequestMethod("GET");
		httpConn.setConnectTimeout(10000);       //컨텍션타임아웃 10초
		httpConn.setReadTimeout(5000);
		
		Charset charset = Charset.forName("UTF-8");
        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),charset));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        //JSON Parsing
        JSONParser parser = new JSONParser();
        Object obj = parser.parse( response.toString() );
        JSONObject resData = (JSONObject) obj;
        JSONObject clientJson = new JSONObject();
        for(Object o : (JSONArray) resData.get("elements")) {
        	JSONObject j = (JSONObject) o;
        	clientJson.put((String) j.get("profile_nickname"), j.get("uuid"));
        }
        return clientJson;
	}

	public void sendAlarm(JSONObject clientList, String token) throws Exception {
		String url = "https://kapi.kakao.com/v1/api/talk/friends/message/default/send";
		HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
		httpConn.setRequestProperty("Authorization", "Bearer "+token);
		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(10000);       //컨텍션타임아웃 10초
		httpConn.setReadTimeout(5000);
		
		String text = "this is test message";
		String link = "http://www.naver.com";
		String button_title = "move to naver";
		httpConn.setDoOutput(true);
		
		String query = 
				"template_object={\"object_type\":\"text\",\"text\":\""
				+ text
				+ "\",\"link\":{\"web_url\": \""
				+ link
				+ "\"},\"button_title\":\""
				+ button_title
				+ "\"}"
				+ "&receiver_uuids=";
		
		KakaoService ks = new KakaoService();
		clientList.forEach((key, val)->{
			ks.uuidList += val+",";
		});
		ks.uuidList = ks.uuidList.substring(0, ks.uuidList.length()-1);
		ks.uuidList += "\"]";
		System.out.println(ks.uuidList);
		query += ks.uuidList;
		ks.uuidList = "[\"";
		
        DataOutputStream wr = new DataOutputStream(httpConn.getOutputStream());
        wr.writeBytes(query);
        wr.flush();
        wr.close();
        
        Charset charset2 = Charset.forName("UTF-8");
        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),charset2));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());


	}
}
