package com.lcwd.user.sevice.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.sevice.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
