package com.example.simpledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// entrypoint
@SpringBootApplication
public class SimpleDemoApplication {

  public static void main(String[] args) {
    // flow of application
    // user -> request to rest endpoint
    // user -> request(eg. postman) -> controller(rest) -> service(business logic) -> repository(db
    // interaction for entity) (then vice versa)
    SpringApplication.run(SimpleDemoApplication.class, args);
  }
}
