package com.liemily.reportgeneration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by Emily Li on 14/08/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.liemily.reportgeneration")
@Lazy
public class ReportGenerationConfig {
}
