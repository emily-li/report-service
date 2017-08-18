package com.liemily.reportgeneration;

import com.liemily.reportgeneration.reports.Report;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/**
 * Created by Emily Li on 14/08/2017.
 */
@Component
@Lazy
public class ReportInitialiser {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private ApplicationContext applicationContext;

    @Autowired
    public ReportInitialiser(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    Report getReport(String report) {
        try {
            return (Report) applicationContext.getBean(report);
        } catch (ClassCastException | NoSuchBeanDefinitionException e) {
            logger.error("No such report with report name " + report);
            return null;
        }
    }
}
