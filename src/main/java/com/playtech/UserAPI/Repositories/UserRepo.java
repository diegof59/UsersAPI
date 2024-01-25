package com.playtech.UserAPI.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playtech.UserAPI.Models.UserEntity;

/**
 * This interface represents a repository for managing UserEntity objects.
 */
public interface UserRepo extends JpaRepository<UserEntity, Long> {

  /**
   * Retrieves an optional UserEntity object based on the provided document number.
   *
   * @param documentNumber the document number to search for
   * @return an optional UserEntity object that matches the document number, or an empty optional if not found
   */
  Optional<UserEntity> findByDocumentNumber(String documentNumber);
}
