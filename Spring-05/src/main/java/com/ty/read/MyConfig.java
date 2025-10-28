package com.ty.read;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.ty.read")
@PropertySource(value = "classpath:userdata.properties")
public class MyConfig {

}
