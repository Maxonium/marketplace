package org.project.marketplace.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.marketplace.entities.UserEntity;
import org.project.marketplace.enums.Role;
import org.project.marketplace.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public boolean createUser(UserEntity userEntity)
    {
        if (userRepository.findByLoginEmail(userEntity.getLoginEmail()) != null) {return false;}
        userEntity.setUserActive(true);
        userEntity.getRoles().add(Role.ROLE_USER);
        log.info("Saving new user with email: {}", userEntity.getLoginEmail());
        return true;
    }
}
