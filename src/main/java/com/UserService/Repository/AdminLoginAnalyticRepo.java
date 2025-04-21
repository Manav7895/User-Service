package com.UserService.Repository;

import com.UserService.Entity.Admin.AdminLoginAnalytic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manav Rajput Java Developer
 */
@Repository
public interface AdminLoginAnalyticRepo extends JpaRepository<AdminLoginAnalytic, Long> {
}
