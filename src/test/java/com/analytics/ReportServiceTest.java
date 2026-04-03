package com.analytics;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ReportService Tests")
class ReportServiceTest {

    private ReportService reportService;
    private List<SalesData> data;

    @BeforeEach
    void setUp() {
        reportService = new ReportService(new AnalyticsService());
        data = List.of(
            new SalesData("North", "Laptop", 75000.0, 300),
            new SalesData("South", "Phone",  45000.0, 500)
        );
    }

    // ── Report Consistency Tests ──────────────────────────────────────────────

    @Test
    @DisplayName("Report title should match input")
    void testReportTitle() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertEquals("Q1 Report", report.getTitle());
    }

    @Test
    @DisplayName("Report total revenue should be accurate")
    void testReportTotalRevenue() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertEquals(120000.0, report.getTotalRevenue(), 0.001);
    }

    @Test
    @DisplayName("Report total units should be accurate")
    void testReportTotalUnits() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertEquals(800, report.getTotalUnits());
    }

    @Test
    @DisplayName("Report average revenue should be accurate")
    void testReportAverageRevenue() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertEquals(60000.0, report.getAverageRevenue(), 0.001);
    }

    @Test
    @DisplayName("Report top region should be North")
    void testReportTopRegion() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertEquals("North", report.getTopRegion());
    }

    @Test
    @DisplayName("Report top product should be Phone")
    void testReportTopProduct() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertEquals("Phone", report.getTopProduct());
    }

    @Test
    @DisplayName("Report generatedAt should not be null or empty")
    void testReportGeneratedAt() {
        Report report = reportService.generateReport("Q1 Report", data);
        assertNotNull(report.getGeneratedAt());
        assertFalse(report.getGeneratedAt().isEmpty());
    }
}
