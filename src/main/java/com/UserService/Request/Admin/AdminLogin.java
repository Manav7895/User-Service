package com.UserService.Request.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manav Rajput Java Developer
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminLogin {
    private String emailId;
    private String password;
}
