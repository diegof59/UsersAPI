package com.playtech.UserAPI.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// import java.util.HashMap;
import java.util.List;

import com.playtech.UserAPI.Models.UserEntity;
import com.playtech.UserAPI.Services.UserService;

/**
 * This class represents the controller for managing user-related operations in the API.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * Retrieves a list of all users.
   *
   * @return ResponseEntity containing the list of users
   */
  @GetMapping
  public ResponseEntity<List<UserEntity>> listUsers() {
    return ResponseEntity.ok(userService.listUsers());
  }

  /**
   * Retrieves a specific user by their ID.
   *
   * @param userID the ID of the user to retrieve
   * @return ResponseEntity containing the user
   */
  @GetMapping("/{userID}")
  public ResponseEntity<UserEntity> getUser(@PathVariable Long userID) {
    return ResponseEntity.ok(userService.getUserById(userID));
  }

  /**
   * Creates a new user.
   *
   * @param user the user to create
   * @return ResponseEntity containing the created user
   */
  @PostMapping
  public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<UserEntity>(userService.createUser(user), headers, HttpStatus.CREATED);
  }

  /**
   * Updates an existing user.
   *
   * @param userID the ID of the user to update
   * @param user the updated user data
   * @return ResponseEntity containing the updated user
   */
  @PutMapping("/{userID}")
  public ResponseEntity<UserEntity> updateUser(@PathVariable Long userID, @RequestBody UserEntity user) {
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<UserEntity>(userService.updateUser(userID, user), headers, HttpStatus.OK);
  }

  /* 
   * Patch an existing user with partial updates.
   * 
   * @param userID the ID of the user to patch
   * @param updates the partial updates to apply to the user
   * @return the patched user
   */
  /* @PatchMapping("/{userID}")
  public User patchUser(@PathVariable String userID, @RequestBody HashMap<String, Object> updates) {
    return userService.patchUser(userID, updates);
  } */

  /**
   * Deletes a user by their ID.
   *
   * @param userID the ID of the user to delete
   * @return the deleted user
   */
  @DeleteMapping("/{userID}")
  public ResponseEntity<UserEntity> deleteUser(@PathVariable Long userID) {
    return ResponseEntity.ok(userService.deleteUser(userID));
  }

}
