package com.ivan.spring_context.annotation_based_config.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FooChildB implements IFoo {
    
}
