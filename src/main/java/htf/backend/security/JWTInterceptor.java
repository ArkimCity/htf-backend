package htf.backend.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htf.backend.exception.UnauthorizedException;
import htf.backend.service.JWTService;
import net.minidev.json.JSONObject;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JWTInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "Authorization";

    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
    	if (request.getMethod().equals("OPTIONS")) {
    		return true; 
    	}else {
    		final String token = request.getHeader(HEADER_AUTH).split(" ")[1];
    		if(token != null && jwtService.isUsable(token)){
    			System.out.println(process(request,response));;
    			return true;
    		} else {
    			throw new UnauthorizedException();
    		}
    	}
    }
    
    protected String process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        return readBody(req);
    }
    public static String readBody(HttpServletRequest request) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
        return builder.toString();
    }
}