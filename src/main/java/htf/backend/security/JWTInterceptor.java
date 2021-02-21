package htf.backend.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import htf.backend.exception.UnauthorizedException;
import htf.backend.service.JWTService;
import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JWTInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "Authorization";

    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    	if (request.getMethod().equals("OPTIONS")) {
    		return true; 
    	}else {
    		final String token = request.getHeader(HEADER_AUTH).split(" ")[1];
    		if(token != null && jwtService.isUsable(token)){
    			System.out.println(request);
    			return true;
    		} else {
    			throw new UnauthorizedException();
    		}
    	}
    }
}