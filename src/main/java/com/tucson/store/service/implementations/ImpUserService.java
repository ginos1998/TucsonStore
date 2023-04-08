package com.tucson.store.service.implementations;

import com.tucson.store.entity.User;
import com.tucson.store.repository.UserRepository;
import com.tucson.store.service.interfaces.IntUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImpUserService implements IntUserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  public List<User> listAllUsers() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public void saveUser(User user) {
    userRepository.save(user);
  }

  /**
   * Add a user using, for now, postman
   * @param userInfo User class object to add.
   */
  @Override
  @Transactional
  public void addUser(User userInfo) {
    userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
    userRepository.save(userInfo);
  }

  @Override
  @Transactional
  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  @Override
  @Transactional(readOnly = true)
  public User findUser(User user) {
    return userRepository.findById(user.getIdUser()).orElse(null);
  }
}
