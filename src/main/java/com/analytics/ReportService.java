package com.analytics;

import java.util.List;

public class ReportService {

    private final AnalyticsService analyticsService;

    public ReportService(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    public Report generateReport(String title, List<SalesData> data) {
        double totalRevenue   = analyticsService.calculateTotalRevenue(data);
        int totalUnits        = analyticsService.calculateTotalUnits(data);
        double avgRevenue     = analyticsService.calculateAverageRevenue(data);
        String topRegion      = analyticsService.getTopRegion(data);
        String topProduct     = analyticsService.getTopProduct(data);

        return new Report(title, totalRevenue, totalUnits, avgRevenue, topRegion, topProduct);
    }
}
