package com.playtech.UserAPI.Services;

// import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playtech.UserAPI.Models.UserEntity;
import com.playtech.UserAPI.Repositories.UserRepo;
import com.playtech.UserAPI.Utils.UserNotFoundException;

/**
 * This class represents the service layer for managing user-related operations.
 */
@Service
public class UserService {
  
  @Autowired
  private UserRepo userRepo;

  /**
   * Retrieves a list of all users.
   *
   * @return a list of UserEntity objects representing the users.
   */
  public List<UserEntity> listUsers() {
    return userRepo.findAll();
  }

  /**
   * Retrieves a user by their ID.
   *
   * @param id The ID of the user to retrieve.
   * @return The UserEntity object representing the user.
   * @throws UserNotFoundException If the user with the specified ID is not found.
   */
  public UserEntity getUserById(Long id) {
    return userRepo.findById(id)
    .orElseThrow(() -> new UserNotFoundException("User not found"));
  }

  /**
   * Retrieves a user entity based on the provided document number.
   *
   * @param documentNumber The document number of the user.
   * @return The user entity associated with the document number.
   * @throws UserNotFoundException If the user with the given document number is not found.
   */
  public UserEntity getUserByDocumentNumber(String documentNumber) {
    return userRepo.findByDocumentNumber(documentNumber)
    .orElseThrow(() -> new UserNotFoundException("User not found"));
  }

  /**
   * Creates a new user.
   *
   * @param user the user entity to be created
   * @return the created user entity
   * @throws IllegalArgumentException if the user is null
   */
  public UserEntity createUser(UserEntity user) {
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }
    return userRepo.save(user);
  }

  /**
   * Updates a user in the database.
   *
   * @param userID The ID of the user to be updated.
   * @param user The updated user entity.
   * @return The updated user entity.
   * @throws UserNotFoundException If the user with the given ID does not exist.
   * @throws IllegalArgumentException If the user parameter is null.
   */
  public UserEntity updateUser(Long userID, UserEntity user) {
    
    if (userID != null && !userRepo.existsById(userID)) {
      throw new UserNotFoundException("User not found");
    }
    if (user == null) {
      throw new IllegalArgumentException("User cannot be null");
    }

    user.setId(userID);

    return userRepo.save(user);
  }

  /*
  /**
   * Updates a user in the database only with the specified fields.
   *
   * @param userID The ID of the user to be updated.
   * @param user The updated user entity.
   * @return The updated user entity.
   * @throws UserNotFoundException If the user with the given ID does not exist.
   * @throws IllegalArgumentException If the user parameter is null.
   *
  public User patchUser(String userID, HashMap<String, Object> userPatch) {
   
    User user = userRepo.findByDocumentID(userID)
    .orElseThrow(() -> new UserNotFoundException("User not found"));

    HashMap.Entry 

    return userRepo.save(user);
  } */

  /**
   * Deletes a user with the specified ID.
   *
   * @param id the ID of the user to delete
   * @return the deleted user entity
   * @throws IllegalArgumentException if the ID is null
   * @throws UserNotFoundException if the user with the specified ID is not found
   */
  public UserEntity deleteUser(Long id) {
    if (id == null) {
      throw new IllegalArgumentException("Id cannot be null");
    }
    UserEntity deletedUser = userRepo.findById(id)
      .orElseThrow(() -> new UserNotFoundException("User not found"));

    userRepo.deleteById(id);

    return deletedUser;
  }
}
