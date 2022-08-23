package com.tutorial.jwtauthentication.repository;

import com.tutorial.jwtauthentication.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
    List<Services> findByStatus(String status);
}
