package com.analytics;

public class SalesData {

    private String region;
    private String product;
    private double revenue;
    private int unitsSold;

    public SalesData(String region, String product, double revenue, int unitsSold) {
        this.region = region;
        this.product = product;
        this.revenue = revenue;
        this.unitsSold = unitsSold;
    }

    public String getRegion()   { return region; }
    public String getProduct()  { return product; }
    public double getRevenue()  { return revenue; }
    public int getUnitsSold()   { return unitsSold; }

    @Override
    public String toString() {
        return String.format("[%s | %s | Revenue: %.2f | Units: %d]", region, product, revenue, unitsSold);
    }
}
