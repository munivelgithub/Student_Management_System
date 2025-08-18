package com.Munivel.Student_Management.ServiceTest;

import com.Munivel.Student_Management.Student_Model.Student;
import com.Munivel.Student_Management.Student_Repository.Student_Repo;
import com.Munivel.Student_Management.Student_Service.Student_Service;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//manuall mock implemented
//public class StudentServiceTest {
//    @Mock
//    private Student_Repo student_repo;

//    AutoCloseable closeable;
//    @Autowired
//    private Student_Service service;
//    private Student student;
//
//    @BeforeEach
//    public void setUp(){
//        closeable= MockitoAnnotations.openMocks(this);
//        student=new Student(9,"thaliva","male",89);
//    }
//   @Test
//   public void test1(){
//        //first line should be entity
//       mock(Student.class);
//        mock(Student_Repo.class);
//      //entity
//       when(student_repo.save(student)).thenReturn(student);
//       assertThat(service.add_student(student)).isEqualTo("Success");
//   }
//
//    @AfterEach
//    public void TearDown() throws  Exception{
//        closeable.close();
//    }
//
//}
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private Student_Service service;

    private Student student;

    @BeforeEach
    public void setUp(){
        student=new Student(7,"hhh","male",89,"munivel.javadev@gmail.com");
    }
    @Test
    public void test(){
        service.add_student(student);
    }
}

