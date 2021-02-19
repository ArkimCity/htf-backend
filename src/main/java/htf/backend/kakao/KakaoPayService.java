package htf.backend.kakao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class KakaoPayService {
	public static String memId = "";
	public static String tid = "";
	
	public static JSONObject requestPayment(String memId, String rank, String price, String FRONT_SERVER) throws Exception {
		String url = "https://kapi.kakao.com/v1/payment/ready";
		HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
		httpConn.setRequestProperty("Authorization", "KakaoAK 8fe7fc4a9f57b22dc5a4a209121cb7f5");
		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(10000);       //컨텍션타임아웃 10초
		httpConn.setReadTimeout(5000);
		
		httpConn.setDoOutput(true);
		
		String query =
				"cid=TCSUBSCRIP&" +
				"partner_order_id=0000&" +
				"partner_user_id="+memId+"&" +
				"item_name="+rank+"&" +
				"quantity=1&" +
				"total_amount="+price+"&" +
				"tax_free_amount=0&" +
				"approval_url="+FRONT_SERVER+"/kakaoSub&" +
				"cancel_url="+FRONT_SERVER+"/kakaoSub&" +
				"fail_url="+FRONT_SERVER+"/kakaoSub";
						
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
        return new JSONObject(response.toString());
	}
	
	public static JSONObject requestApprove(String tid, String pg_token, String memId) throws Exception {
		String url = "https://kapi.kakao.com/v1/payment/approve";
		HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
		httpConn.setRequestProperty("Authorization", "KakaoAK 8fe7fc4a9f57b22dc5a4a209121cb7f5");
		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(10000);       //컨텍션타임아웃 10초
		httpConn.setReadTimeout(5000);
		
		httpConn.setDoOutput(true);
		
		String query =
				"cid=TCSUBSCRIP&" +
				"tid="+tid+"&" +
				"partner_order_id=0000&" +
				"partner_user_id="+memId+"&" +
				"pg_token="+pg_token;
						
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
        JSONObject res = new JSONObject(response.toString());
        return res;
	}
	
	public static void requestSubscribe(String sid, String price, String memId) throws Exception {
		String url = "https://kapi.kakao.com/v1/payment/subscription";
		HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
		httpConn.setRequestProperty("Authorization", "KakaoAK 8fe7fc4a9f57b22dc5a4a209121cb7f5");
		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(10000);       //컨텍션타임아웃 10초
		httpConn.setReadTimeout(5000);
		
		httpConn.setDoOutput(true);
		
		String query =
				"cid=TCSUBSCRIP&" +
				"sid="+sid+"&" +
				"partner_order_id=0000&" +
				"partner_user_id="+memId+"&" +
				"quantity=1&" + 
				"tax_free_amount=0&" +
				"total_amount="+price;
						
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
