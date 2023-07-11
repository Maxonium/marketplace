package org.project.marketplace.repositories;

import org.project.marketplace.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findByLoginEmail(String loginEmail);
}
