package com.ojolali.isale;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").
		allowedOrigins("https://posclient.herokuapp.com");
	}
//
//	 @Autowired
//	 private Environment env;
//
//
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                String urls = env.getProperty("cors.urls");
//                CorsRegistration reg = registry.addMapping("/api/**");
//                for(String url: urls.split(",")) {
//                    reg.allowedOrigins(url);
//                }
//            }
//        };
//    }
}
