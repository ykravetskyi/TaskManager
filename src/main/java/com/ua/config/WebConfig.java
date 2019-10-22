package com.ua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.ua")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setCache(true);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/src/main/webapp/pages/form_login_reg/css/")
                .addResourceLocations("src/main/webapp/pages/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/src/main/webapp/pages/form_login_reg/images/")
                .addResourceLocations("/src/main/webapp/pages/images/");
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/src/main/webapp/pages/fonts/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/src/main/webapp/pages/js/");
    }

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);

        javaMailSender.setUsername("adammoran19@gmail.com");
        javaMailSender.setPassword("qweasdzxc1997");

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        return javaMailSender;
    }
}

