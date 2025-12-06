package com.ksa.pfm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksa.pfm.model.User;
import com.ksa.pfm.service.ForgotPasswordService;

@Controller
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @GetMapping("/forgotPwd")
    public String forgotPasswordPage() {
        return "forgotPassword";
    }

    @PostMapping("/verifyMail")
    public String verifyEmail(@RequestParam String email, Model model) {
        var userOpt = forgotPasswordService.findUserByEmail(email);
        if (userOpt.isEmpty()) {
            model.addAttribute("msg", "Invalid Email! Please enter a registered email.");
            return "forgotPassword";
        }

        forgotPasswordService.sendOtp(userOpt.get());
        model.addAttribute("email", email);
        model.addAttribute("msg", "OTP has been sent to your email.");
        return "otppage";
    }

    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String email,
                            @RequestParam Integer otp,
                            Model model) {

        var userOpt = forgotPasswordService.findUserByEmail(email);
        if (userOpt.isEmpty()) {
            model.addAttribute("error", "Invalid Email! Please try again.");
            return "forgotPassword";
        }

        String result = forgotPasswordService.verifyOtp(userOpt.get(), otp);
        switch (result) {
            case "expired":
                model.addAttribute("error", "OTP expired! Request a new one.");
                return "forgotPassword";
            case "incorrect":
                model.addAttribute("error", "Incorrect OTP! Please try again.");
                model.addAttribute("email", email);
                return "otppage";
            default:
                model.addAttribute("email", email);
                return "newPassword";
        }
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String repeatPassword,
                                 Model model) {
        boolean success = forgotPasswordService.updatePassword(email, password, repeatPassword);
        if (!success) {
            model.addAttribute("msg", "Passwords do not match!");
            model.addAttribute("email", email);
            return "newPassword";
        }
        model.addAttribute("msg", "Password has been changed successfully!");
        return "login";
    }
}