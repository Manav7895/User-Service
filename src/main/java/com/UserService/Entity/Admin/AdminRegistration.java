package com.UserService.Entity.Admin;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manav Rajput Java Developer
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_adminRegistration")
public class AdminRegistration {

    private Long adminId;
    private String firstName;
    private String lastName;
    private String contactNo;

}
