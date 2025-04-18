package com.UserService.Request.Admin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
/**
 * @author Manav Rajput Java Developer
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRegistration {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Contact number is required")
    private String contactNo;

    private boolean status;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

}
