package io.davi.tdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.davi.tdd.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
