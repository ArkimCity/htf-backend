package htf.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String[] EXCLUDE_PATHS = {
    	"/loginMember",
    	"/login*",
    	"/insertAdmin",
        "/create",
        "/member/**",
        "/loginAdmin",
        "/tempCheck",
        "/error/**",
        "/getAdIdByMchId",
        "/fireKakao"
    };
 
    @Autowired
    private JWTInterceptor JWTInterceptor;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(JWTInterceptor)
                        .addPathPatterns("/**")
                        .excludePathPatterns(EXCLUDE_PATHS);
    }
}