package com.liemily.reportgeneration;

import com.liemily.reportgeneration.reports.Report;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Emily Li on 14/08/2017.
 */
@SpringBootTest
public class ReportInitialiserTest {
    @Autowired
    private ReportInitialiser reportInitialiser;

    @Test
    public void testGetReport() {
        Report report = reportInitialiser.getReport("stockReport");
        Assert.assertNotNull(report);
    }
}
