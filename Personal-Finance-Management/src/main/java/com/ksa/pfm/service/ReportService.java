package com.ksa.pfm.service;

import java.util.List;

import com.ksa.pfm.model.Transaction;

public interface ReportService {
    
    /**
     * Fetches transactions based on filters, requiring the user ID.
     */
    List<Transaction> getMonthlyTransactions(Long userId, int month, int year, String type);
    
    /**
     * Generates the PDF report content as a byte array.
     */
    byte[] generateReportPdf(List<Transaction> transactions, String reportTitle);
}