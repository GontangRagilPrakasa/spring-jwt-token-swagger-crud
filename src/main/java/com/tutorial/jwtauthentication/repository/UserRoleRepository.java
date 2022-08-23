package com.tutorial.jwtauthentication.repository;

import com.tutorial.jwtauthentication.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {
//    UserRoles findByUserIdAndRole(Long userId, String role);
}
