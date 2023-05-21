package com.tucson.store.utils;

import java.util.List;

public class CommonFunctions {
  public static boolean isNotNullNotEmpty(List<Object> list) {
    return list != null && !list.isEmpty();
  }
}
