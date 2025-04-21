package com.UserService.Service;

import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Response.BaseApiResponse;

/**
 * @author Manav Rajput Java Developer
 */
public interface AdminServiceAbstract {

    void AdminLogin();
    BaseApiResponse AdminRegistration(AdminRegistration adminRegistration);
}
