package com.analytics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {

    private String title;
    private double totalRevenue;
    private int totalUnits;
    private double averageRevenue;
    private String topRegion;
    private String topProduct;
    private String generatedAt;

    public Report(String title, double totalRevenue, int totalUnits,
                  double averageRevenue, String topRegion, String topProduct) {
        this.title = title;
        this.totalRevenue = totalRevenue;
        this.totalUnits = totalUnits;
        this.averageRevenue = averageRevenue;
        this.topRegion = topRegion;
        this.topProduct = topProduct;
        this.generatedAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getTitle()          { return title; }
    public double getTotalRevenue()   { return totalRevenue; }
    public int getTotalUnits()        { return totalUnits; }
    public double getAverageRevenue() { return averageRevenue; }
    public String getTopRegion()      { return topRegion; }
    public String getTopProduct()     { return topProduct; }
    public String getGeneratedAt()    { return generatedAt; }

    @Override
    public String toString() {
        return "\n========== " + title + " ==========\n" +
               "Generated At    : " + generatedAt + "\n" +
               "Total Revenue   : $" + String.format("%.2f", totalRevenue) + "\n" +
               "Total Units     : " + totalUnits + "\n" +
               "Average Revenue : $" + String.format("%.2f", averageRevenue) + "\n" +
               "Top Region      : " + topRegion + "\n" +
               "Top Product     : " + topProduct + "\n" +
               "==========================================";
    }
}
