package com.UserService.Service;

import com.UserService.Request.Admin.AdminLogin;
import com.UserService.Request.Admin.AdminRegistration;
import com.UserService.Response.BaseApiResponse;

/**
 * @author Manav Rajput Java Developer
 */
public interface AdminServiceAbstract {

    BaseApiResponse AdminLogin(AdminLogin adminLogin);
    BaseApiResponse AdminRegistration(AdminRegistration adminRegistration);
}
