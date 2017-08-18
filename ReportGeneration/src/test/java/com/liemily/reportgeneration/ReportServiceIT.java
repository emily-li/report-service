package com.liemily.reportgeneration;

import com.liemily.reportgeneration.reports.FILE_TYPE;
import com.liemily.reportgeneration.reports.REPORT_NAME;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Path;

/**
 * Created by Emily Li on 14/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceIT {
    @Autowired
    private ReportService reportService;

    @Test
    public void testRequestReport() throws Exception {
        ReportRequest reportRequest = new ReportRequest(REPORT_NAME.STOCK_REPORT, FILE_TYPE.XML);
        Path reportPath = reportService.executeReport(reportRequest);
        Assert.assertTrue(reportPath.toFile().exists());
    }
}
