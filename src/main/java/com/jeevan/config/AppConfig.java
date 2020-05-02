package com.jeevan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.jeevan")
@Import({ MessagingConfiguration.class, MessagingListnerConfiguration.class })
public class AppConfig
{

	// Put Other Application configuration here.
}