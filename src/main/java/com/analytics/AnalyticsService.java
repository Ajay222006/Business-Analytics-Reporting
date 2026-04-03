package com.analytics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsService {

    // Total revenue from all sales
    public double calculateTotalRevenue(List<SalesData> data) {
        if (data == null || data.isEmpty()) return 0.0;
        return data.stream().mapToDouble(SalesData::getRevenue).sum();
    }

    // Total units sold
    public int calculateTotalUnits(List<SalesData> data) {
        if (data == null || data.isEmpty()) return 0;
        return data.stream().mapToInt(SalesData::getUnitsSold).sum();
    }

    // Average revenue per record
    public double calculateAverageRevenue(List<SalesData> data) {
        if (data == null || data.isEmpty()) return 0.0;
        return calculateTotalRevenue(data) / data.size();
    }

    // Region with highest total revenue
    public String getTopRegion(List<SalesData> data) {
        if (data == null || data.isEmpty()) return "N/A";
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesData::getRegion,
                        Collectors.summingDouble(SalesData::getRevenue)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

    // Product with highest units sold
    public String getTopProduct(List<SalesData> data) {
        if (data == null || data.isEmpty()) return "N/A";
        return data.stream()
                .collect(Collectors.groupingBy(
                        SalesData::getProduct,
                        Collectors.summingInt(SalesData::getUnitsSold)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }
}
