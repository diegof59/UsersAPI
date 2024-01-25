package com.playtech.UserAPI.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class provides advice for handling UserNotFoundException in the UserAPI application.
 */
@ControllerAdvice
class UserNotFoundAdvice {

  /**
   * Handles the UserNotFoundException and returns a 404 response with the error message.
   *
   * @param ex The UserNotFoundException that was thrown.
   * @return The error message as a string.
   */
  @ResponseBody
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(UserNotFoundException ex) {
    return ex.getMessage();
  }
}
