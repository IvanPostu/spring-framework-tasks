package com.ivan.spring_context.java_based_beans.configs_b;

import com.ivan.spring_context.java_based_beans.BeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {
    @Bean(name = "bean_B")
    public BeanB getBeanB(){
        return new BeanB();
    }
}
