package com.ivan.spring_context.java_based_beans;

import org.springframework.context.annotation.Bean;

public class BeanDConfig {

    @Bean
    public BeanD getBeanD(){
        return new BeanD();
    }
    
}
