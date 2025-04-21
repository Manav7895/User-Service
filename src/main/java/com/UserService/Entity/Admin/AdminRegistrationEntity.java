package com.UserService.Entity.Admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav Rajput Java Developer
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_adminRegistration")
public class AdminRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId", nullable = false)
    private Long adminId;

    @Column(name = "firstName", nullable = false, length = 255)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 255)
    private String lastName;

    @Column(name = "contactNo", nullable = false, length = 50)
    private String contactNo;

    @Column(name = "status", nullable = false, length = 10)
    private boolean status;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdminLoginAnalytic> loginAnalytics = new ArrayList<>();
}
