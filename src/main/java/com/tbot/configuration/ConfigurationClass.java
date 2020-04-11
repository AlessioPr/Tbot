package com.tbot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application.dev.properties")
@Configuration
public class ConfigurationClass {

}
