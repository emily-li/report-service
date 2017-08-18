package com.liemily.reportgeneration;

import com.liemily.reportgeneration.reports.Report;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Emily Li on 14/08/2017.
 */
@RunWith(SpringRunner.class)
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
