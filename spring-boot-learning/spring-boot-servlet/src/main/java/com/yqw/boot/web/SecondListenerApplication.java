package com.yqw.boot.web;

import com.yqw.boot.web.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot整合Listener方式二
 */
@SpringBootApplication
public class SecondListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondListenerApplication.class, args);

    }

    /**
     * 注册listener
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
        return bean;
    }
}
