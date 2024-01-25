package com.playtech.UserAPI.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long cityId;

  @Column(length = 100, nullable = false)
  private String cityName;
  @Column(length = 100)
  private String cityCountry;
  @Column(length = 100)
  private String cityState;

  protected City() {}

  public City(String name, String country, String state) {
    this.cityName = name;
    this.cityCountry = country;
    this.cityState = state;
  }

  public Long getCityId() {
    return cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public String getCityCountry() {
    return cityCountry;
  }

  public String getCityState() {
    return cityState;
  }

  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  public void setCityName(String name) {
    this.cityName = name;
  }

  public void setCityCountry(String country) {
    this.cityCountry = country;
  }

  public void setCityState(String state) {
    this.cityState = state;
  }
}
