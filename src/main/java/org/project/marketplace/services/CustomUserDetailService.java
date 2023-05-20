package org.project.marketplace.services;

import lombok.RequiredArgsConstructor;
import org.project.marketplace.entities.UserEntity;
import org.project.marketplace.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService
{
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String loginEmail) throws UsernameNotFoundException
    {
        UserEntity userEntity = userRepository.findByLoginEmail(loginEmail);
        if (userEntity != null)
        {
            return new org.springframework.security.core.userdetails.User(userEntity.getLoginEmail(),
                    userEntity.getPassword(),
                    userEntity.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getAuthority()))
                            .collect(Collectors.toList()));
        } else
        {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
