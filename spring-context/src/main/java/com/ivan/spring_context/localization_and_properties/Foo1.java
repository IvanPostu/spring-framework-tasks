package com.ivan.spring_context.localization_and_properties;

import java.util.Arrays;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.ivan.spring_context.localization_and_properties.example.IFoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Foo1 {
    // Hello world
    private String fooStr1;
    // default
    private String fooStr2;
    // default
    // private String fooStr3;

    @Value(value = "#{ T(java.lang.Math).random() * 100 }")
    private double randomDouble;

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
    private MessageSource messageSource;

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

    // Here will be BeanCreationException
    // @Value("${example.b}")
    // public void setFoo3(String fooStr) {
    // this.fooStr2 = fooStr;
    // }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");

        Locale locale = Locale.ENGLISH;
        String helloUserMessage = messageSource.getMessage("hello.user",
                new Object[] { "ALbert" }, locale);
        System.out.println(helloUserMessage);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy");
    }

    public void display() {
        System.out.println(Arrays.asList(fooB, fooStr1, fooStr2));
    }
}
