package com.ivan.spring_context.localization_and_properties.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "FFFooChildC")
public class FooChildC implements IFoo {
    
}
