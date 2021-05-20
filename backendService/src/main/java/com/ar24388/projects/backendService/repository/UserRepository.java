package com.ar24388.projects.backendService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ar24388.projects.backendService.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
