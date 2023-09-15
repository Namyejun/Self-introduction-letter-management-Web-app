package com.yejun.app.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yejun.app.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserId(String userId);
}
