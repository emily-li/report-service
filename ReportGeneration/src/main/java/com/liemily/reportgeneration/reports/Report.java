package com.liemily.reportgeneration.reports;

import com.liemily.reportgeneration.ReportRequest;
import com.liemily.reportgeneration.exceptions.ReportMarshallingException;
import com.liemily.reportgeneration.exceptions.ReportWritingException;
import com.liemily.reportgeneration.reports.domain.ReportItems;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by Emily Li on 14/08/2017.
 */
public abstract class Report {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    abstract ReportItems generateReportItems(ReportRequest reportRequest);

    public Path executeReport(ReportRequest reportRequest) throws ReportMarshallingException, ReportWritingException {
        ReportItems reportItems = generateReportItems(reportRequest);
        String reportContents = generateReport(reportItems, reportRequest.getFileType());

        Path reportPath = generateReportPath(reportRequest.getFileType());
        writeReport(reportContents, reportPath);
        return reportPath;
    }

    private Path generateReportPath(FILE_TYPE fileType) {
        Path path = Paths.get(UUID.randomUUID().toString() + "." + fileType.toString().toLowerCase());
        path.toFile().deleteOnExit();
        return path;
    }

    private void writeReport(String report, Path path) throws ReportWritingException {
        try {
            Files.write(path, report.getBytes());
        } catch (IOException e) {
            logger.info("Failed to write report to " + path.toAbsolutePath());
            throw new ReportWritingException("Failed to write report to " + path.toAbsolutePath(), e);
        }
        logger.info("Wrote report to " + path.toAbsolutePath());
    }

    private String generateReport(ReportItems reportItems, FILE_TYPE fileType) throws ReportMarshallingException {
        String contents;
        if (fileType.equals(FILE_TYPE.XML)) {
            contents = generateXML(reportItems);
        } else {
            throw new UnsupportedOperationException("Unsupported report file type " + fileType);
        }
        return contents;
    }

    private String generateXML(ReportItems reportItems) throws ReportMarshallingException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ReportItems.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            try (StringWriter stringWriter = new StringWriter()) {
                marshaller.marshal(reportItems, stringWriter);
                return stringWriter.toString();
            }
        } catch (JAXBException | IOException e) {
            String msg = "Failed to marshal report to string";
            logger.info(msg, e);
            throw new ReportMarshallingException(msg, e);
        }
    }
}
