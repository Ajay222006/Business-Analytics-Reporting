package com.analytics;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Sample sales data
        List<SalesData> data = List.of(
            new SalesData("North", "Laptop",  75000.0, 300),
            new SalesData("South", "Phone",   45000.0, 500),
            new SalesData("East",  "Tablet",  30000.0, 200),
            new SalesData("West",  "Monitor", 20000.0, 100),
            new SalesData("North", "Phone",   15000.0, 250)
        );

        // Generate report
        AnalyticsService analyticsService = new AnalyticsService();
        ReportService reportService       = new ReportService(analyticsService);

        Report report = reportService.generateReport("Q1 Business Analytics Report", data);

        // Print report
        System.out.println(report);
    }
}
