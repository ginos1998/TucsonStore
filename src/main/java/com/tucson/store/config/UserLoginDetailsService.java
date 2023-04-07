package com.tucson.store.config;

import com.tucson.store.entity.User;
import com.tucson.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserLoginDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user= userRepository.findByUsername(username);

    return user.map(UserLoginUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado :("));
  }
}
