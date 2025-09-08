package com.Munivel.Student_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ther is an comman line runner interface in that interface only the run mehtod is there
// @SpringBootApplication define this is an startup point and please start heare and set up
// everything automatically.@
// it is an composit annotation that contain three main annotaion
@SpringBootApplication(scanBasePackages = "com.Munivel.Student_Management")
public class StudentManagementApplication {
  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
    //		ConfigurableApplicationContext s=SpringApplication.run(StudentManagementApplication.class,
    // args);
    //		Student ss=s.getBean(Student.class);
    // must do context.close();

  }
}
