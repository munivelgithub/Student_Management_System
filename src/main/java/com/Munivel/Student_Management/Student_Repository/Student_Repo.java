package com.Munivel.Student_Management.Student_Repository;

import com.Munivel.Student_Management.Student_Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Student_Repo extends JpaRepository<Student,Integer> {

}
