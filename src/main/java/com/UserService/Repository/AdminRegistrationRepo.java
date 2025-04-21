package com.UserService.Repository;

import com.UserService.Entity.Admin.AdminRegistrationEntity;
import com.UserService.Request.Admin.AdminRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manav Rajput Java Developer
 */
@Repository
public interface AdminRegistrationRepo extends JpaRepository<AdminRegistrationEntity, Long> {
}
