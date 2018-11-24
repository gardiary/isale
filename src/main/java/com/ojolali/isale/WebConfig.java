package com.ojolali.isale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").
		allowedOrigins("https://posclient.herokuapp.com");
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
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
