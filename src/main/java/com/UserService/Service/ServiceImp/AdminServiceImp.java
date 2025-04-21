package com.UserService.Service.ServiceImp;

import com.UserService.Constant.RestMappingConstant;
import com.UserService.Entity.Admin.AdminLoginAnalytic;
import com.UserService.Entity.Admin.AdminRegistrationEntity;
import com.UserService.Exception.AdminException;
import com.UserService.Repository.AdminLoginAnalyticRepo;
import com.UserService.Repository.AdminRegistrationRepo;
import com.UserService.Request.Admin.AdminLogin;
import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Response.AdminResponse.AdminData;
import com.UserService.Response.BaseApiResponse;
import com.UserService.Service.AdminServiceAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Manav Rajput Java Developer
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminServiceAbstract {

    private final PasswordEncoder passwordEncoder;
    private final AdminRegistrationRepo adminRegistrationRepo;
    private final AdminLoginAnalyticService adminLoginAnalyticService;


    @Override
    public BaseApiResponse AdminLogin(AdminLogin adminLogin) {
        try {
            Optional<AdminRegistrationEntity> adminOpt = adminRegistrationRepo.findByEmailId(adminLogin.getEmailId());
            if (adminOpt.isPresent()) {
                AdminRegistrationEntity admin = adminOpt.get();
                if (passwordEncoder.matches(adminLogin.getPassword(), admin.getPassword())) {
                    // Use separate method to handle session token creation and saving
                    String sessionToken = adminLoginAnalyticService.generateAndSaveSessionToken(admin);

                    AdminData adminData = AdminData.builder()
                            .contactNo(admin.getContactNo())
                            .email(admin.getEmail())
                            .sessionToken(sessionToken)
                            .status(admin.isStatus())
                            .firstName(admin.getFirstName())
                            .lastName(admin.getLastName())
                            .build();

                    return setSuccess(RestMappingConstant.Message.LOGIN_SUCCESSFULLY, RestMappingConstant.StatusCodes.SUCCESS, adminData);
                } else {
                    throw new AdminException(RestMappingConstant.Message.UNAUTHORIZED, HttpStatus.FORBIDDEN);
                }
            } else {
                throw new AdminException(RestMappingConstant.Message.ADMIN_NOT_EXIST, HttpStatus.FORBIDDEN);
            }
        } catch (AdminException adminException) {
            throw new AdminException(RestMappingConstant.Message.COMMON_MESSAGE, HttpStatus.FORBIDDEN);
        }
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
            return setSuccess(RestMappingConstant.Message.SAVED_MESSAGE, RestMappingConstant.StatusCodes.SUCCESS);
        } catch (AdminException adminException) {
            throw new AdminException(RestMappingConstant.Message.COMMON_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public BaseApiResponse setSuccess(String message, String status) {
        return BaseApiResponse.builder()
                .success(1)
                .status(status)
                .message(message)
                .build();
    }

    public BaseApiResponse setSuccess(String message, String status, Object data) {
        return BaseApiResponse.builder()
                .success(1)
                .data(data)
                .status(status)
                .message(message)
                .build();
    }
}
