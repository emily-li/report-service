package com.liemily.reportgeneration.reports;

import com.liemily.reportgeneration.ReportRequest;

import java.util.LinkedHashMap;

/**
 * Created by Emily Li on 14/08/2017.
 */
public abstract class Report {
    abstract LinkedHashMap<String, Object> getReportValues(ReportRequest reportRequest);

    public String executeReport(ReportRequest reportRequest) {
        LinkedHashMap<String, Object> reportValues = getReportValues(reportRequest);
        return getReportFile(reportRequest.getFileType(), reportValues);
    }

    private String getReportFile(FILE_TYPE fileType, LinkedHashMap<String, Object> keyValues) {
        String reportContents;
        switch (fileType) {
            case XML:
                reportContents = getXML(keyValues);
                break;
            case CSV:
                reportContents = getCSV(keyValues);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported report file type " + fileType);
        }
        return reportContents;
    }

    private String getXML(LinkedHashMap<String, Object> keyValues) {
        return null;
    }

    private String getCSV(LinkedHashMap<String, Object> keyValues) {
        String xml = getXML(keyValues);
        return convertXMLToCsv(xml);
    }

    private String convertXMLToCsv(String xml) {
        return null;
    }
}
