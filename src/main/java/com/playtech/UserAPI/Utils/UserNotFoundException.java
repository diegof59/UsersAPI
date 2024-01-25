package com.playtech.UserAPI.Utils;

/**
 * Exception thrown when a user is not found.
 */
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}