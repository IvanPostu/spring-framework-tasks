package com.ivan.spring_context.localization_and_properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class LocalizationConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:locale/translations");
        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(false);

        return ms;
    }

  

}
