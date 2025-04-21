package com.UserService.Entity.Admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Manav Rajput Java Developer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginAnalytic {
    private Long loginId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId", nullable = false)
    private AdminRegistrationEntity admin;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedDate;

    @Column(name = "sessionToken")
    private String sessionToken;

    @Column(name = "expireAt")
    private LocalDateTime expiresAt;
}
