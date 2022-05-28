package com.ivan.spring_context.java_based_beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { BeanDConfig.class })
public class DemoConfig {
    
    @Bean(name = "bean_A")
    public BeanA getBeanA(){
        return new BeanA();
    }

    @Bean(name = "beanB")
    public BeanB getBeanB(){
        return new BeanB();
    }

    @Bean()
    public BeanC getBeanC(){
        return new BeanC();
    }
}
