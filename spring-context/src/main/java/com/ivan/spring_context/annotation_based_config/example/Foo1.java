package com.ivan.spring_context.annotation_based_config.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Foo1 {
    private String foo;
    
    @Value("${example.a:#{null}}")
    @Autowired(required = true)
    public void setFoo(String foo) {
        this.foo = foo;
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PreDestroy");
    }

    public void display(){
        System.out.println(foo);
    }
}
