package com.liemily.reportgeneration;

import com.liemily.reportgeneration.exceptions.ReportGenerationException;
import com.liemily.reportgeneration.reports.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

/**
 * Created by Emily Li on 14/08/2017.
 */
@Component
@Lazy
public class ReportService {
    private ReportInitialiser reportInitialiser;

    @Autowired
    public ReportService(ReportInitialiser reportInitialiser) {
        this.reportInitialiser = reportInitialiser;
    }

    public Path executeReport(ReportRequest reportRequest) throws ReportGenerationException {
        Report report = reportInitialiser.getReport(reportRequest.getReportName());
        return report.executeReport(reportRequest);
    }
}
