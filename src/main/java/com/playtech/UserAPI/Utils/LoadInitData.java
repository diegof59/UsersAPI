package com.playtech.UserAPI.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import com.playtech.UserAPI.Models.City;
import com.playtech.UserAPI.Models.DocumentType;
import com.playtech.UserAPI.Models.SessionStatus;
import com.playtech.UserAPI.Models.UserEntity;
import com.playtech.UserAPI.Repositories.CityRepo;
import com.playtech.UserAPI.Repositories.DocumentTypeRepo;
import com.playtech.UserAPI.Repositories.UserRepo;

@Configuration
public class LoadInitData {


  /**
   * Logger to display DB init loggin in console
   */
  private static final Logger log = LoggerFactory.getLogger(LoadInitData.class);

  /**
   * @param userRepo
   * @param documentTypeRepo
   * @param cityRepo
   * @return function to load initial data in DB
   * 
   * This loads initial data in DB for basic use testing 
   */
  @Bean
  @ConditionalOnProperty(
    name = {"INIT_DB"},
    havingValue = "true" // Only run this when INIT_DB is set to true in evnironment variables
  )
  CommandLineRunner initDatabase(UserRepo userRepo, DocumentTypeRepo documentTypeRepo, CityRepo cityRepo) {
    return args -> {

      DocumentType cc = new DocumentType("CC", "Cédula de Ciudadanía");
      DocumentType ce = new DocumentType("CE", "Cédula de Extranjería");

      log.info("Preloading " + documentTypeRepo.save(cc));
      log.info("Preloading " + documentTypeRepo.save(ce));

      City bogota = new City("Bogotá", "Bogotá DC", "Colombia");
      City medellin = new City("Medellín", "Antioquia", "Colombia");
      City cali = new City("Cali", "Valle del Cauca", "Colombia");

      log.info("Preloading " + cityRepo.save(bogota));
      log.info("Preloading " + cityRepo.save(medellin));
      log.info("Preloading " + cityRepo.save(cali));

      log.info("Preloading " + userRepo.save(new UserEntity(cc, "123456789", "John", "Doe", LocalDate.parse("1988-01-09"), "3001234567", "john_doe@test.com", "Calle 123", bogota, SessionStatus.INACTIVE)));
      log.info("Preloading " + userRepo.save(new UserEntity(cc, "234567890", "Jane", "Doe", LocalDate.parse("1990-02-10"), "3002345678", "jane_doe@test.com", "Calle 234", medellin, SessionStatus.INACTIVE)));
      log.info("Preloading " + userRepo.save(new UserEntity(ce, "345678901", "Alice", "Smith", LocalDate.parse("1992-03-11"), "3003456789", "alice_smith@test.com", "Calle 345", cali, SessionStatus.INACTIVE)));
      log.info("Preloading " + userRepo.save(new UserEntity(cc, "456789012", "Bob", "Johnson", LocalDate.parse("1994-04-12"), "3004567890", "bob_johnson@test.com", "Calle 456", bogota, SessionStatus.INACTIVE)));
      log.info("Preloading " + userRepo.save(new UserEntity(ce, "567890123", "Charlie", "Brown", LocalDate.parse("1996-05-13"), "3005678901", "charlie_brown@test.com", "Calle 567", medellin, SessionStatus.INACTIVE)));
    };
  }
}
