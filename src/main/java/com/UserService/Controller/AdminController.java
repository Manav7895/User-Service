package com.UserService.Controller;

import com.UserService.Encryption.Decode;
import com.UserService.Request.Admin.AdminLogin;
import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Request.Checksum;
import com.UserService.Service.AdminServiceAbstract;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manav Rajput Java Developer
 */
@RestController
public class AdminController {

    @Autowired
    private AdminServiceAbstract adminServiceAbstract;

    @Autowired
    Decode decode;

    @Autowired
    private ObjectMapper objectMapper;

    public void AdminLogin(@RequestBody AdminLogin adminLogin){

    }


    public void AdminRegistration(@RequestBody Checksum checksum) throws JsonProcessingException {
        AdminRegistration adminRegistration = objectMapper.readValue(decode.decryptText(checksum.getChecksum()), AdminRegistration.class);
        adminServiceAbstract.AdminRegistration(adminRegistration);
    }
}

