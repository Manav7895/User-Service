package com.UserService.Service.ServiceImp;

import com.UserService.Entity.Admin.AdminRegistrationEntity;
import com.UserService.Repository.AdminRegistrationRepo;
import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Response.BaseApiResponse;
import com.UserService.Service.AdminServiceAbstract;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Manav Rajput Java Developer
 */
@Service
public class AdminServiceImp implements AdminServiceAbstract {

    private final PasswordEncoder passwordEncoder;
    private final AdminRegistrationRepo adminRegistrationRepo;

    public AdminServiceImp(PasswordEncoder passwordEncoder, AdminRegistrationRepo adminRegistrationRepo) {
        this.passwordEncoder = passwordEncoder;
        this.adminRegistrationRepo = adminRegistrationRepo;
    }

    @Override
    public void AdminLogin() {

    }

    @Override
    public BaseApiResponse AdminRegistration(AdminRegistration adminRegistration) {
        try {
            AdminRegistrationEntity adminRegistrationEntity = AdminRegistrationEntity.builder()
                    .email(adminRegistration.getEmail())
                    .status(true)
                    .firstName(adminRegistration.getFirstName())
                    .lastName(adminRegistration.getLastName())
                    .contactNo(adminRegistration.getContactNo())
                    .password(passwordEncoder.encode(adminRegistration.getPassword()))
                    .build();

            // save to DB
            adminRegistrationRepo.save(adminRegistrationEntity);
            return setSuccess("Saved SuccessFully", "200");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public BaseApiResponse setSuccess(String message, String status){
        return BaseApiResponse.builder()
                .success(1)
                .status(status)
                .message(message)
                .build();
    }
}
