package org.santander.cucumber.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.santander.cucumber.demo"})
public class ApplicationConfig {
}