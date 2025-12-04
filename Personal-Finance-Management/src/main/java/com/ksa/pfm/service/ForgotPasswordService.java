package com.ksa.pfm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ksa.pfm.model.ForgotPassword;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.ForgotPasswordRepo;
import com.ksa.pfm.repo.UserRepo;

import java.util.Random;
import java.util.Optional;

@Service
public class ForgotPasswordService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ForgotPasswordRepo forgotPasswordRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Random random = new Random();

    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public int generateOtp() {
        return random.nextInt(900000) + 100000;
    }

    @Transactional
    public void sendOtp(User user) {
        int otp = generateOtp();
        String subject = "OTP for Forgot Password";
        String body = "This is your OTP: " + otp;
        emailService.sendEmail(user.getEmail(), subject, body);

        ForgotPassword fp = new ForgotPassword(otp, new Date(System.currentTimeMillis() + 70 * 1000), user);
        forgotPasswordRepo.save(fp);
    }

    @Transactional
    public String verifyOtp(User user, Integer otp) {
        ForgotPassword fp = forgotPasswordRepo.findByOtpAndUser(otp, user).orElse(null);
        if (fp == null) {
            return "incorrect"; // OTP wrong
        }

        Date now = new Date();
        if (fp.getExpirrationTime().before(now)) {
            user.setForgotPassword(null);
            userRepo.save(user);
            forgotPasswordRepo.delete(fp);
            return "expired"; // OTP expired
        }

        // OTP valid → delete
        user.setForgotPassword(null);
        userRepo.save(user);
        forgotPasswordRepo.delete(fp);
        return "valid";
    }

    @Transactional
    public boolean updatePassword(String email, String password, String repeatPassword) {
        if (!password.equals(repeatPassword)) return false;
        String encoded = passwordEncoder.encode(password);
        userRepo.updatePassword(email, encoded);
        return true;
    }
}

