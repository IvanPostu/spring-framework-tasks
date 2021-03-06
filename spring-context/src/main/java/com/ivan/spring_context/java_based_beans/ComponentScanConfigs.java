package com.ivan.spring_context.java_based_beans;

import com.ivan.spring_context.java_based_beans.configs_a.ConfigA;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.ivan.spring_context.java_based_beans.configs_b", "com.ivan.spring_context.repo_example" }, basePackageClasses = {
        ConfigA.class,  })
public class ComponentScanConfigs {

}
