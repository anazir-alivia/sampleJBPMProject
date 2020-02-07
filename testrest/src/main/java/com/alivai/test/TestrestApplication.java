package com.alivai.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//extends SpringBootServletInitializer
@SpringBootApplication
public class TestrestApplication  {
  public static void main(String[] args) {
    SpringApplication.run(TestrestApplication.class, args);
  }
  
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    return application.sources(new Class[] { applicationClass });
//  }
//  
//  private static Class<TestrestApplication> applicationClass = TestrestApplication.class;
}
