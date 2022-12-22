package io.davi.tdd01.repositories;

import io.davi.tdd01.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
