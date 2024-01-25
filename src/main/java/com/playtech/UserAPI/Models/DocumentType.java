package com.playtech.UserAPI.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DocumentType {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer documentTypeId;
  
  @Column(length = 10)
  private String documentTypeCode;
  @Column(length = 50, nullable = false)
  private String documentTypeName;

  protected DocumentType() {}

  public DocumentType(String documentTypeCode, String documentTypeName) {
    this.documentTypeCode = documentTypeCode;
    this.documentTypeName = documentTypeName;
  }

  public Integer getDocumentTypeId() {
    return documentTypeId;
  }

  public String getDocumentTypeCode() {
    return documentTypeCode;
  }

  public String getDocumentTypeName() {
    return documentTypeName;
  }

  public void setDocumentTypeId(Integer documentTypeId) {
    this.documentTypeId = documentTypeId;
  }

  public void setDocumentTypeCode(String documentTypeCode) {
    this.documentTypeCode = documentTypeCode;
  }

  public void setDocumentTypeName(String documentTypeName) {
    this.documentTypeName = documentTypeName;
  }

}
