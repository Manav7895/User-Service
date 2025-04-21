package com.UserService.Controller;

import com.UserService.Constant.RestMappingConstant;
import com.UserService.Encryption.Decode;
import com.UserService.Exception.AdminException;
import com.UserService.Request.Admin.AdminLogin;
import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Request.Checksum;
import com.UserService.Response.BaseApiResponse;
import com.UserService.Service.AdminServiceAbstract;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manav Rajput Java Developer
 */
@RestController
@RequestMapping(RestMappingConstant.API_PREFIX)
public class AdminController {

    @Autowired
    private AdminServiceAbstract adminServiceAbstract;

    @Autowired
    Decode decode;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(RestMappingConstant.Endpoints.ADMIN_REGISTRATION)
    public ResponseEntity<BaseApiResponse> AdminRegistration(@RequestBody Checksum checksum) throws JsonProcessingException {
        try {
            AdminRegistration adminRegistration = objectMapper.readValue(decode.decryptText(checksum.getChecksum()), AdminRegistration.class);
            BaseApiResponse baseApiResponse = adminServiceAbstract.AdminRegistration(adminRegistration);
            return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new AdminException(RestMappingConstant.Message.COMMON_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);        }
    }
}

