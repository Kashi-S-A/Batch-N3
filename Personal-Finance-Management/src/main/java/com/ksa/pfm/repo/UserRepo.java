package com.ksa.pfm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
