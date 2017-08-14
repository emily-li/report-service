package com.liemily.reportgeneration;

import com.liemily.reportgeneration.config.ReportGenerationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by Emily Li on 14/08/2017.
 */
@SpringBootApplication
@Import(ReportGenerationConfig.class)
public class ReportGenerationApp {
    public static void main(String[] args) {
        SpringApplication.run(ReportGenerationApp.class, args);
    }
}
