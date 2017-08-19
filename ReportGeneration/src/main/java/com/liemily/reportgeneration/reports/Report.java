package com.liemily.reportgeneration.reports;

import com.liemily.reportgeneration.ReportRequest;
import com.liemily.reportgeneration.ReportWriter;
import com.liemily.reportgeneration.exceptions.ReportGenerationException;
import com.liemily.reportgeneration.reports.domain.ReportItems;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by Emily Li on 14/08/2017.
 */
public abstract class Report {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private ReportWriter reportWriter;

    public Report(ReportWriter reportWriter) {
        this.reportWriter = reportWriter;
    }

    abstract ReportItems generateReportItems(ReportRequest reportRequest);

    public Path executeReport(ReportRequest reportRequest) throws ReportGenerationException {
        ReportItems reportItems = generateReportItems(reportRequest);
        Path reportPath = generateReportPath(reportRequest.getFileType());
        reportWriter.write(reportItems, reportRequest.getFileType(), reportPath);
        return reportPath;
    }

    private Path generateReportPath(FILE_TYPE fileType) {
        Path path = Paths.get(UUID.randomUUID().toString() + "." + fileType.toString().toLowerCase());
        path.toFile().deleteOnExit();
        return path;
    }
}
