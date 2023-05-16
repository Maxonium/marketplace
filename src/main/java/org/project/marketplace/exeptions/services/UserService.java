package org.project.marketplace.exeptions.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.marketplace.entities.UserEntity;
import org.project.marketplace.enums.Role;
import org.project.marketplace.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(UserEntity userEntity)
    {
        if (userRepository.findByLoginEmail(userEntity.getLoginEmail()) != null) {return false;}
        userEntity.setUserActive(true);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.getRoles().add(Role.ROLE_USER);
        log.info("Saving new user with email: {}", userEntity.getLoginEmail());
        return true;
    }
}
