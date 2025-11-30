package com.ksa.pfm.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.UserRepo;
import com.ksa.pfm.service.ReportService;

import jakarta.servlet.http.HttpServletResponse; // <-- CRITICAL IMPORT for streaming PDF

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;
 
    
    @Autowired
    private UserRepo userRepo;

    // 1. Initial Page Load
    @GetMapping("/report")
    public String showReportPage(Model model) {
        model.addAttribute("transactions", Collections.emptyList());
        return "report";
    }

    // 2. Form Submission: Handles the month, year, and report type filters
    @PostMapping("/reports/filter") 
    public String filterMonthlyReport(
            @RequestParam("month") int month,
            @RequestParam("year") int year,
            @RequestParam("reportType") String reportType,
            Principal principal,
            Model model) 
    {
        // Safely get the User entity and its ID
        String email = principal.getName();
    	User user = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        Long userId = user.getId(); 
        
        // Fetch the data
        List<Transaction> transactions = reportService.getMonthlyTransactions(userId, month, year, reportType);
        
        // Add the results and the selected filters back to the Model
        model.addAttribute("transactions", transactions);
        model.addAttribute("selectedMonth", month);
        model.addAttribute("selectedYear", year);
        model.addAttribute("selectedType", reportType);

        return "report"; 
    }
    
    // 3. PDF DOWNLOAD HANDLER
    @GetMapping("/reports/download")
    public void downloadPdfReport(
            @RequestParam("month") int month,
            @RequestParam("year") int year,
            @RequestParam("reportType") String reportType,
            Principal principal,
            HttpServletResponse response) throws Exception 
    {
        // 1. Get userId (required to fetch data)
        String email = principal.getName();
    	User user = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        Long userId = user.getId(); 

        // 2. Fetch the filtered data
        List<Transaction> transactions = reportService.getMonthlyTransactions(userId, month, year, reportType);

        // 3. Set HTTP headers for PDF download
        String filename = String.format("%s_Report_%d_%d.pdf", reportType, month, year);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        // 4. Generate the PDF byte array
        String reportTitle = String.format("Monthly %s Report (%d/%d)", reportType, month, year);
        // NOTE: This calls the fully implemented generateReportPdf from ReportServiceImpl
        byte[] pdfBytes = reportService.generateReportPdf(transactions, reportTitle);

        // 5. Stream the PDF bytes to the response output stream
        response.getOutputStream().write(pdfBytes);
        response.getOutputStream().flush();
    }
}