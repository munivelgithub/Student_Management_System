package com.Munivel.Student_Management.Student_Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity(name="Student")
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Scope(value = "prototype")
// now how can we add constrains in table like
// how we add that alter table details add constraint con unique email varchat(30);
// when we say column definition test means name varchar(30)
@Table(name = "Student",
     uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique",columnNames = "Email")
     })
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // now on should modidfy my table name means what i can mention

    private int id;
    @Column(
            name = "Name",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false)// so i need an colum name in Name and it should be in text and not null
    // when i say updatable no one can modigy my table name
    private String name;

    @Column(name="Gender",nullable = false,columnDefinition = "TEXT",
    updatable = false)
    private String gender;

    @Column(name="Age",nullable = false,updatable = false)
    private int age;
    @Column(name = "Email",columnDefinition = "TEXT"
    ,updatable = false)// unique = true this is one way when we say unique true it is an uniques constrain add constraint cond email unique like that means
    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(int id, String name, String gender, int age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }
}






