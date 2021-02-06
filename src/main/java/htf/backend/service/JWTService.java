package htf.backend.service;

import java.util.Map;

public interface JWTService {
	<T> String create(String key, T data, String subject);
	Map<String, Object> get(String key);
	long getMemberId();
	boolean isUsable(String jwt);
	
}