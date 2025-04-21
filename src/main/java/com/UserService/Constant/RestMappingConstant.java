package com.UserService.Constant;

/**
 * @author Manav Rajput Java Developer
 */
public interface RestMappingConstant {
    String API_PREFIX = "api";

    interface Endpoints {
        String HEALTH_CHECK = "healthCheck";
        String ADMIN_REGISTRATION = "admin/register";
    }

    interface Message{
        String COMMON_MESSAGE = "Something went wrong. Please try again later.";
        String SAVED_MESSAGE = "Saved SuccessFully";
    }

    interface StatusCodes {
        String SUCCESS = "200";
        String UNAUTHORIZED = "401";
        String FORBIDDEN = "403";
        String BAD_REQUEST = "400";
    }


}
