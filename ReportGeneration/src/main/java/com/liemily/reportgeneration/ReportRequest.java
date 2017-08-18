package com.liemily.reportgeneration;

import com.liemily.reportgeneration.reports.FILE_TYPE;
import com.liemily.reportgeneration.reports.REPORT_NAME;

/**
 * Created by Emily Li on 18/08/2017.
 */
public class ReportRequest {
    private final REPORT_NAME reportName;
    private final FILE_TYPE fileType;

    public ReportRequest(REPORT_NAME reportName, FILE_TYPE fileType) {
        this.reportName = reportName;
        this.fileType = fileType;
    }

    public REPORT_NAME getReportName() {
        return reportName;
    }

    public FILE_TYPE getFileType() {
        return fileType;
    }
}
