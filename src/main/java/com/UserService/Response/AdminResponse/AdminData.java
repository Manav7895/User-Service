package com.UserService.Response.AdminResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manav Rajput Java Developer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminData {
    private String firstName;
    private String lastName;
    private String contactNo;
    private boolean status;
    private String email;
    private String password;
    private String sessionToken;

}
