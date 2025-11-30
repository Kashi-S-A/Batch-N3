package com.ksa.pfm.service.impl;

import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.awt.Color; // CRITICAL: Use java.awt.Color for OpenPDF

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.TransactionType;
import com.ksa.pfm.repo.ReportRepo;
import com.ksa.pfm.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepo reportRepo; 

    @Override
    public List <Transaction> getMonthlyTransactions(Long userId, int month, int year, String type) {
        
        // 1. Convert the String type (e.g., "INCOME") to the Enum (TransactionType.INCOME)
        TransactionType transactionType = TransactionType.valueOf(type); 
        
        // 2. Call the custom repository method
        return reportRepo.findMonthlyReports(userId, transactionType, month, year);
    }
    
    
    @Override
    public byte[] generateReportPdf(List<Transaction> transactions, String reportTitle) {
        
        // Use ByteArrayOutputStream to hold the PDF content in memory
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        // Create the PDF Document (using A4 size)
        Document document = new Document(PageSize.A4);

        try {
            // Set up the PdfWriter to output to the byte array stream
            PdfWriter.getInstance(document, baos);
            document.open();

            // --- 1. TITLE ---
            // Title Font: Blue, Bold, Size 20
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, new Color(13, 110, 253));
            Paragraph title = new Paragraph(reportTitle, fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);
            
            // --- 2. TRANSACTION TABLE SETUP ---
            PdfPTable table = new PdfPTable(5); // 5 columns: Date, Description, Category, Type, Amount
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            
            // Define relative widths for column layout
            table.setWidths(new float[] {1.5f, 3.5f, 2.5f, 1.5f, 2.0f}); 

            // Headers
            String[] headers = {"Date", "Description", "Category", "Type", "Amount"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new Color(230, 240, 255)); // Light blue background
                cell.setPadding(5);
                table.addCell(cell);
            }

            // Data Rows (Removed totalAmount calculation variable as it's not needed)
            for (Transaction txn : transactions) {
                // Data Cells
                table.addCell(new Phrase(txn.getDate()));
                table.addCell(new Phrase(txn.getDescription()));
                table.addCell(new Phrase(txn.getCategory().getName())); 
                table.addCell(new Phrase(txn.getType().toString()));
                
                // Amount Cell (Right Aligned)
                String amountString = String.format("%.2f", txn.getAmount());
                PdfPCell amountCell = new PdfPCell(new Phrase( amountString));
                amountCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                amountCell.setPadding(5);
                table.addCell(amountCell);
            }
            
            document.add(table);
            
            // --- 3. GRAND TOTAL FOOTER REMOVED ---
            // The code blocks for 'totalAmount' calculation, 'totalTable' setup,
            // and 'document.add(totalTable)' have been removed to meet the requirement.

            document.close();
            
            // Return the byte array content of the PDF
            return baos.toByteArray();

        } catch (DocumentException e) {
            e.printStackTrace();
            // Handle error: return empty array
            return new byte[0]; 
        }
    }
}