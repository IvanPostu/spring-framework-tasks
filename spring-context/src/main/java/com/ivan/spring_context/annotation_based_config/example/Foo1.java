package com.ivan.spring_context.annotation_based_config.example;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Foo1 {
    //Hello world
    private String fooStr1;
    //default
    private String fooStr2;
    
    // Will be injected @Primary bean P.S. If primary isn't specified
    // then will be throwed UnsatisfiedDependencyException with inner
    // NoUniqueBeanDefinitionException.
    @Autowired
    public IFoo fooB;

    @Autowired
    @Qualifier(value = "fooChildB")
    public IFoo fooBByBeanName;

    @Autowired
    @Qualifier(value = "foo_child_A")
    public IFoo fooA;

    @Autowired
    @Qualifier(value = "FFFooChildC")
    public IFoo fooC;
    
    @Value("${example.a:#{'default'}}")
    @Autowired(required = true)
    public void setFoo1(String fooStr) {
        this.fooStr1 = fooStr;
    }

    @Value("${example.b:#{'default'}}")
    @Autowired(required = true)
    public void setFoo2(String fooStr) {
        this.fooStr2 = fooStr;
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
        System.out.println(Arrays.asList(fooB, fooStr1, fooStr2));
    }
}
