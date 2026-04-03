package com.analytics;

import org.junit.jupiter.api.*;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AnalyticsService Tests")
class AnalyticsServiceTest {

    private AnalyticsService service;
    private List<SalesData> data;

    @BeforeEach
    void setUp() {
        service = new AnalyticsService();
        data = List.of(
            new SalesData("North", "Laptop",  75000.0, 300),
            new SalesData("South", "Phone",   45000.0, 500),
            new SalesData("East",  "Tablet",  30000.0, 200)
        );
    }

    // ── Data Accuracy Tests ──────────────────────────────────────────────────

    @Test
    @DisplayName("Total revenue should equal sum of all revenues")
    void testTotalRevenue() {
        assertEquals(150000.0, service.calculateTotalRevenue(data), 0.001);
    }

    @Test
    @DisplayName("Total units should equal sum of all units sold")
    void testTotalUnits() {
        assertEquals(1000, service.calculateTotalUnits(data));
    }

    @Test
    @DisplayName("Average revenue should be total / number of records")
    void testAverageRevenue() {
        assertEquals(50000.0, service.calculateAverageRevenue(data), 0.001);
    }

    @Test
    @DisplayName("Top region should be North with highest revenue")
    void testTopRegion() {
        assertEquals("North", service.getTopRegion(data));
    }

    @Test
    @DisplayName("Top product should be Phone with highest units")
    void testTopProduct() {
        assertEquals("Phone", service.getTopProduct(data));
    }

    // ── Edge Case Tests ───────────────────────────────────────────────────────

    @Test
    @DisplayName("Empty list should return 0 for revenue")
    void testEmptyListRevenue() {
        assertEquals(0.0, service.calculateTotalRevenue(Collections.emptyList()));
    }

    @Test
    @DisplayName("Empty list should return 0 for units")
    void testEmptyListUnits() {
        assertEquals(0, service.calculateTotalUnits(Collections.emptyList()));
    }

    @Test
    @DisplayName("Null input should return 0 for revenue")
    void testNullRevenue() {
        assertEquals(0.0, service.calculateTotalRevenue(null));
    }

    @Test
    @DisplayName("Null input should return N/A for top region")
    void testNullTopRegion() {
        assertEquals("N/A", service.getTopRegion(null));
    }

    @Test
    @DisplayName("Single record average should equal its own revenue")
    void testSingleRecordAverage() {
        List<SalesData> single = List.of(new SalesData("North", "Laptop", 10000.0, 100));
        assertEquals(10000.0, service.calculateAverageRevenue(single), 0.001);
    }
}
