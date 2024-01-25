package com.playtech.UserAPI.Models;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class UserEntity {
  /**
   * Represents a user entity in the system.
   */
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "documentTypeId")
  private DocumentType documentType;

  @Column(length = 20)
  private String documentNumber;
  @Column(length = 200)
  private String firstName;
  @Column(length = 200)
  private String lastName;
  private LocalDate dateBirth;
  @Column(length = 50)
  private String mobilePhone;
  @Column(length = 200)
  private String email;
  @Column(length = 200)
  private String address;

  @ManyToOne
  @JoinColumn(name = "cityId")
  private City city;

  @Column(length = 10)
  private SessionStatus sessionActive;

  protected UserEntity() {}

  /**
   * Constructs a new UserEntity object with the specified parameters.
   *
   * @param documentType   the document type of the user
   * @param documentNumber the document number of the user
   * @param firstName      the first name of the user
   * @param lastName       the last name of the user
   * @param dateBirth      the date of birth of the user
   * @param mobilePhone    the mobile phone number of the user
   * @param email          the email address of the user
   * @param address        the address of the user
   * @param city           the city of the user
   * @param sessionActive  the session status of the user
   */
  public UserEntity(DocumentType documentType, String documentNumber, String firstName, String lastName, LocalDate dateBirth, String mobilePhone, String email, String address, City city, SessionStatus sessionActive) {
    this.documentType = documentType;
    this.documentNumber = documentNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateBirth = dateBirth;
    this.mobilePhone = mobilePhone;
    this.email = email;
    this.address = address;
    this.city = city;
    this.sessionActive = sessionActive;
  }

  /**
    * Returns a string representation of the UserEntity object.
    *
    * @return a formatted string containing the document type, document number, first name, last name, and email of the user
    */
  @Override
  public String toString() {
    return String.format(
        "User: Document Type: '%s', Document Number: '%s', First Name: '%s', Last Name: '%s', Email: '%s'",
        documentType.getDocumentTypeName(), documentNumber, firstName, lastName, email);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * 
   * @param obj the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false if obj is not an instance of UserEntity. Otherwise, true if the id, document type and document number are equal; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof UserEntity))
      return false;
    
      UserEntity user = (UserEntity) obj;

    return Objects.equals(this.id, user.id) && Objects.equals(this.documentType, user.documentType) && Objects.equals(this.documentNumber, user.documentNumber);
  }

  /**
   * Returns a hash code value for the UserEntity object.
   * The hash code is based on the id, documentType, and documentNumber fields.
   *
   * @return the hash code value for the UserEntity object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.documentType, this.documentNumber);
  }

  public Long getId() {
    return id;
  }

  public DocumentType getDocumentType() {
    return documentType;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getDateBirth() {
    return dateBirth;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public City getCity() {
    return city;
  }

  public SessionStatus getSessionActive() {
    return sessionActive;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setDateBirth(LocalDate dateBirth) {
    this.dateBirth = dateBirth;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public void setSessionActive(SessionStatus sessionActive) {
    this.sessionActive = sessionActive;
  }
}