package com.Munivel.Student_Management.Student_Service;

import com.Munivel.Student_Management.Student_Model.Student;
import com.Munivel.Student_Management.Student_Repository.Student_Repo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Student_Service {
  @Autowired private Student_Repo repo;

  public Student add_student(Student student) {
    Student s = repo.save(student);
    return s;
  }

  public List<Student> get_all_student() {
    return repo.findAll();
  }

  public Student get_By_Id(int id) {
    return repo.findById(id).orElse(null);
  }

  public Student updates(int id, Student student) {
    Optional<Student> student1 = repo.findById(id);
    if (student1.isPresent()) {
      Student student2 = student1.get();
      student2.setName(student.getName());
      student2.setAge(student.getAge());
      student.setGender(student.getGender());
      return repo.save(student2);
    } else {
      throw new RuntimeException("student not fount " + id);
    }
  }

  public void delete(int id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
    } else {
      throw new RuntimeException("Student Not fount " + id);
    }
  }
}
