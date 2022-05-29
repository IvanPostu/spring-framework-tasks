package com.ivan.spring_context.annotation_based_config.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "FFFooChildC")
public class FooChildC implements IFoo {
    
}
