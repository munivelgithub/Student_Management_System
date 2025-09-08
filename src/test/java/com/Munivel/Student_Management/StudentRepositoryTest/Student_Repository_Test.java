package com.Munivel.Student_Management.StudentRepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.Munivel.Student_Management.Student_Model.Student;
import com.Munivel.Student_Management.Student_Repository.Student_Repo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Student_Repository_Test {
  @Autowired private Student_Repo studentRepo;
  private Student student;
  String name2 = "Willow";

  @BeforeEach
  public void setUp() {
    student = new Student(6, "munivel", "male", 34, "munivel.javadev@gmail.com");
    studentRepo.save(student);
  }

  @Test
  public void Testt() {
    String s = studentRepo.findById(student.getId()).get().getGender();
    assertThat(s).isEqualTo("male");
  }

  @Test
  public void test1() {
    String name = student.getName();
    String name1 = studentRepo.findById(student.getId()).get().getName();
    assertThat(name).isEqualTo(name1); // used an assertJ
    assertThat(student.getAge())
        .isGreaterThanOrEqualTo(studentRepo.findById(student.getId()).get().getAge());
  }

  @Test
  public void test2() {
    String from_one = studentRepo.findById(1).get().getName();
    assertThat(name2).isEqualTo(from_one);
    int id = studentRepo.findById(1).get().getAge();
    assertThat(21).isLessThanOrEqualTo(28);
  }

  @Test
  public void test3() {
    String s = "gangster";
    String s1 = studentRepo.findById(1).get().getName();
    assertThat(s).isEqualTo(s1);
  }

  @AfterEach
  public void TearDown() {
    if (student != null) {
      studentRepo.deleteById(student.getId());
      student = null;
    }
  }
}
