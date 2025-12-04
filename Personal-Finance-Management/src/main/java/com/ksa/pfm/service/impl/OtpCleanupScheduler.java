package com.ksa.pfm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ksa.pfm.model.ForgotPassword;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.ForgotPasswordRepo;
import com.ksa.pfm.repo.UserRepo;

@EnableScheduling
@Component
public class OtpCleanupScheduler {

    @Autowired
    private ForgotPasswordRepo forgotPasswordRepo;
    
    @Autowired
    private UserRepo userRepo ;

    @Transactional
    @Scheduled(fixedDelay = 120000)
    public void removeExpiredOtps() {
        List<ForgotPassword> expiredOtps = forgotPasswordRepo.findByExpirrationTimeBefore(new Date());

        for (ForgotPassword fp : expiredOtps) {
            User user = fp.getUser();
            if (user != null) {
                user.setForgotPassword(null); // break link
                userRepo.save(user);
            }
            forgotPasswordRepo.delete(fp);
        }
    }
}


