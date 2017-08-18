package com.liemily.reportgeneration.reports;

import com.liemily.reportgeneration.ReportRequest;
import com.liemily.reportgeneration.reports.domain.ReportItem;
import com.liemily.reportgeneration.reports.domain.ReportItems;
import com.liemily.stock.Stock;
import com.liemily.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Emily Li on 14/08/2017.
 */
@Component
@Lazy
public class StockReport extends Report {
    private StockService stockService;

    @Autowired
    public StockReport(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    ReportItems generateReportItems(ReportRequest reportRequest) {
        Collection<ReportItem> reportItems = new ArrayList<>();

        Sort.Direction sortDirection = reportRequest.getSortDirection() == null ? Sort.DEFAULT_DIRECTION : reportRequest.getSortDirection();
        Collection<Stock> stocks = getStocks(sortDirection);

        for (Stock stock : stocks) {
            ReportItem reportItem = new ReportItem(stock.getSymbol(), stock.getSymbol(), stock.getValue(), stock.getVolume(), new BigDecimal("0"));
            reportItems.add(reportItem);
        }
        return new ReportItems(reportItems);
    }

    private Collection<Stock> getStocks(Sort.Direction direction) {
        Sort sort = new Sort(direction, "value");
        return stockService.getStocks(sort);
    }
}
