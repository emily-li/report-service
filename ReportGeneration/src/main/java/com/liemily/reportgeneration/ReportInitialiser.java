package com.liemily.reportgeneration;

import com.liemily.reportgeneration.reports.Report;
import com.liemily.reportgeneration.reports.StockReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by Emily Li on 14/08/2017.
 */
@Component
@Lazy
public class ReportInitialiser {
    private ApplicationContext applicationContext;

    @Autowired
    public ReportInitialiser(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    Report getReport(String report) {
        return new StockReport();
    }
}
