package com.playtech.UserAPI.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playtech.UserAPI.Models.DocumentType;

/**
 * This interface represents a repository for managing DocumentType entities.
 */
public interface DocumentTypeRepo extends JpaRepository<DocumentType, Integer> {

  /**
   * Finds a DocumentType by its document type code.
   *
   * @param code the document type code to search for
   * @return an Optional containing the found DocumentType, or an empty Optional if not found
   */
  Optional<DocumentType> findByDocumentTypeCode(String code);

  /**
   * Finds a DocumentType by its document type name.
   *
   * @param type the document type name to search for
   * @return an Optional containing the found DocumentType, or an empty Optional if not found
   */
  Optional<DocumentType> findByDocumentTypeName(String type);
}
