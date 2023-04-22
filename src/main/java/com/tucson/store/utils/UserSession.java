package com.tucson.store.utils;

import com.tucson.store.entity.User;

public class UserSession {
  private static User currentUser;

  private UserSession() {

  }

  public static void setCurrentUser(User currentUser) {
    UserSession.currentUser = currentUser;
  }

  public static User getCurrentUser() {
    return currentUser;
  }
}
