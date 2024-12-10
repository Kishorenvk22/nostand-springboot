package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class consConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
		.allowedOrigins("http://localhost:4200",
				"https://nostand-angular-git-bankai-kishorenvk22s-projects.vercel.app",
				"https://nostand-angular-o9s9hhl1g-kishorenvk22s-projects.vercel.app")
		.allowedHeaders("*")
		.allowedMethods("GET","POST","PUT","PATCH","DELETE");
		
	}
}

