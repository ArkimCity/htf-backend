package htf.backend.subscription;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;


public class KakaoSubscription {
	
	public String tid = null;
	
	public static String getTid() {
		KakaoSubscription ks = new KakaoSubscription();
		return ks.tid;
	}
	
	public static void main(String[] args) throws Exception {
		requestApprove("T2863461929387358684", "d1d2f8bcbc14f522a842");
	}
	
	public static String requestPayment() throws Exception {
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
				"partner_user_id=sh&" +
				"item_name=enterprise&" +
				"quantity=1&" +
				"total_amount=10000&" +
				"tax_free_amount=0&" +
				"approval_url=http://192.168.168.156/kakaoSub&" +
				"cancel_url=http://192.168.168.156/kakaoSub&" +
				"fail_url=http://192.168.168.156/kakaoSub";
						
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
        System.out.println("tid : "+res.getString("tid"));
        System.out.println(res.get("next_redirect_pc_url"));
        KakaoSubscription ks = new KakaoSubscription();
        ks.tid = res.getString("tid");
        return res.getString("next_redirect_pc_url");
	}
	
	public static void requestApprove(String tid, String pg_token) throws Exception {
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
				"partner_user_id=sh&" +
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
	}

}
