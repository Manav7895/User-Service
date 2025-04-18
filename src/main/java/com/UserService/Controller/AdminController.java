package com.UserService.Controller;

import com.UserService.Request.Admin.AdminLogin;
import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Service.ServiceAbstract;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manav Rajput Java Developer
 */
@RestController
public class AdminController {

    @Autowired
    private ServiceAbstract serviceAbstract;

    public void AdminLogin(@RequestBody AdminLogin adminLogin){

    }


    public void AdminRegistration(@RequestBody AdminRegistration adminRegistration){

    }
}

