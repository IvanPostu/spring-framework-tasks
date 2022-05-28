package com.ivan.spring_context.java_based_beans.configs_a;

import com.ivan.spring_context.java_based_beans.BeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Bean(name = "bean_A")
    public BeanA getBeanA(){
        return new BeanA();
    }
}
