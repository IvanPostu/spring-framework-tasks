package com.ivan.spring_context.localization_and_properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackageClasses = {ParentConfig.class})
@PropertySources({
    @PropertySource(value = "classpath:foo.properties", ignoreResourceNotFound = false),
})
public class ParentConfig {
    
}
