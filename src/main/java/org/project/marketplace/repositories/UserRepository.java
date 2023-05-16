package org.project.marketplace.repositories;

import org.project.marketplace.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    UserEntity findByLoginEmail(String loginEmail);
}
