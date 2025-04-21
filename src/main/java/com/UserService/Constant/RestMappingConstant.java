package com.UserService.Constant;

/**
 * @author Manav Rajput Java Developer
 */
public interface RestMappingConstant {
    String API_PREFIX = "api";

    interface Endpoints {
        String HEALTH_CHECK = "healthCheck";
        String ADMIN_REGISTRATION = "admin/register";
        String ADMIN_LOGIN = "admin/login";

    }

    interface Message{
        String COMMON_MESSAGE = "Something went wrong. Please try again later.";
        String SAVED_MESSAGE = "Saved SuccessFully.";
        String LOGIN_SUCCESSFULLY = "Login SuccessFully.";
        String ADMIN_NOT_EXIST = "Admin Not Exist.";
        String UNAUTHORIZED = "Unauthorized";

    }

    interface StatusCodes {
        String SUCCESS = "200";
        String UNAUTHORIZED = "401";
        String FORBIDDEN = "403";
        String BAD_REQUEST = "400";
    }


}
