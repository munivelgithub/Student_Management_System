package com.Munivel.Student_Management.Student_Controller;

import com.Munivel.Student_Management.Student_Model.Student;
import com.Munivel.Student_Management.Student_Service.Student_Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// root end point
@RequestMapping("/student")// global end point
public class Student_Controller {

    @Autowired
    private Student_Service service;
    @RequestMapping("")
    public String show(){
        return "SamBenny";
    }
    @RequestMapping("/session_id")
    public String session(HttpServletRequest request){

        return   request.getSession().getId();
    }
    @PostMapping("/add_student")
    public ResponseEntity<Student> add_Student(@RequestBody Student student){// request body work json data java object convert
         Student student1=service.add_student(student);
         if(student1 != null){
             return new ResponseEntity<Student>(student1,HttpStatus.ACCEPTED);
         }else {
             return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
         }
    }

    @GetMapping("/All_List")
    public ResponseEntity<List<Student>> all_list(){
        List<Student> list=service.get_all_student();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Student> find_single(@PathVariable int id){
        Student s=service.get_By_Id(id);
        return  new ResponseEntity<>(s,HttpStatus.OK);
    }
    @DeleteMapping("del/{id}")
    public ResponseEntity<Void> delete(@PathVariable  int id){
        try{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }catch (RuntimeException e)
        {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("csrf_token")
    public CsrfToken gettoken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }

@PutMapping("/update/{id}")
   public ResponseEntity<Student> update(@PathVariable  int id,@RequestBody Student student){
        Student s=service.updates(id,student);
        return new ResponseEntity<>(s,HttpStatus.OK);
   }













//
//    public void add_Student(){
//       service.add_student(name,gender,age);
//    }
}
