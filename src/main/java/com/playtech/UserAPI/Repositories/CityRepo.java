package com.playtech.UserAPI.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playtech.UserAPI.Models.City;

/**
 * This interface represents a repository for managing City entities.
 */
public interface CityRepo extends JpaRepository<City, Long> {

  /**
   * Finds a city by its name.
   *
   * @param cityName the name of the city to find
   * @return an Optional containing the found city, or an empty Optional if not found
   */
  Optional<City> findByCityName(String cityName);

  /**
   * Finds cities by their state.
   *
   * @param state the state of the cities to find
   * @return a list of cities matching the given state
   */
  List<City> findByCityState(String state);

  /**
   * Finds cities by their country.
   *
   * @param country the country of the cities to find
   * @return a list of cities matching the given country
   */
  List<City> findByCityCountry(String country);
}
