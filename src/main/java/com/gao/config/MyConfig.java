package com.gao.config;

import com.gao.component.MyLocaleResolver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootConfiguration
public class MyConfig {
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver ();
    }

    @Bean
    public ViewResolver viewResolver() {
        return new MyVewResolver ();
    }

    private static class MyVewResolver implements ViewResolver {


        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
