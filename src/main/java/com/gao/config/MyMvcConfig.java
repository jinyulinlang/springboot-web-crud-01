package com.gao.config;

import com.gao.controller.LoginIntercept;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController ("/atgao").setViewName ("success");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer () {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController ("/").setViewName ("login");
                registry.addViewController ("/login.html").setViewName ("login");
                registry.addViewController ("/login").setViewName ("login");
                registry.addViewController ("/main.html").setViewName ("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor (new LoginIntercept ()).addPathPatterns ("/**").excludePathPatterns ("index.html", "/", "user/login");
            }
        };


    }

}
