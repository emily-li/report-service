package com.liemily.reportgeneration.reports;

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
public class StockReportTest {
    @Autowired
    private StockReport stockReport;

    @Test
    public void testGetAllStockValues() throws Exception {
    }

    @Test
    public void testGetAllStockValuesAsc() throws Exception {

    }

    @Test
    public void testGetAllStockValuesDesc() throws Exception {

    }
}
