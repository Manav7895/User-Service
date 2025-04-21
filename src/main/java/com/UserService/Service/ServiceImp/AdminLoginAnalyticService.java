package com.UserService.Service.ServiceImp;

import com.UserService.Entity.Admin.AdminLoginAnalytic;
import com.UserService.Entity.Admin.AdminRegistrationEntity;
import com.UserService.Repository.AdminLoginAnalyticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AdminLoginAnalyticService {

    @Autowired
    private AdminLoginAnalyticRepo adminLoginAnalyticRepo;

    public String generateAndSaveSessionToken(AdminRegistrationEntity adminEntity) {
        String sessionToken = UUID.randomUUID().toString();

        AdminLoginAnalytic analytic = AdminLoginAnalytic.builder()
                .admin(adminEntity)
                .sessionToken(sessionToken)
                .expiresAt(LocalDateTime.now().plusMinutes(30))
                .build();

        adminLoginAnalyticRepo.save(analytic);
        return sessionToken;
    }
}
