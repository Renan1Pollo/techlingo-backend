package com.techlingo.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class ReportUtils {

    public static byte[] generatePdfReport(String reportTemplatePath, Map<String, Object> parameters) {
        JRPdfExporter pdfExporter = new JRPdfExporter();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            InputStream templateInputStream = new FileInputStream(reportTemplatePath);
            JasperDesign jasperDesign = JRXmlLoader.load(templateInputStream);
            JasperReport compiledReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, parameters, new JREmptyDataSource());

            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, filledReport);
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            pdfExporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error generating report: " + e);
        }
        return outputStream.toByteArray();
    }

    public static ResponseEntity<byte[]> buildReportResponse(byte[] reportContent) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(reportContent);
    }
}
