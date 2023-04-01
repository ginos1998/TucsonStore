package com.tucson.store.service.interfaces;

import com.tucson.store.entity.User;

import java.util.List;

public interface IntUserService {
  // CRUD
  List<User> listAllUsers();
  void saveUser(User user);
  void deleteUser(User user);
  User findUser(User user);

}
