package com.Munivel.Student_Management.Student_Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope(value = "prototype")
// @Transient when we annotated this upon the filed saying to the hibernate dont save on the
// database
// @Embeddable
// insted of having one name i can see the multiple name
// now how can we add constrains in table like
// how we add that alter table details add constraint con unique email varchat(30);
// when we say column definition test means name varchar(30)
@Table(
    name = "Student",
    uniqueConstraints = {@UniqueConstraint(name = "student_email_unique", columnNames = "Email")})
public class Student {
  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // now on should modidfy my table name means what i can mention
  // @Value(10)
  private int id;

  @Column(
      name = "Name",
      nullable = false,
      columnDefinition = "TEXT",
      updatable = false) // so i need an colum name in Name and it should be in text and not null
  // when i say updatable no one can modigy my table name
  private String name;

  @Column(name = "Gender", nullable = false, columnDefinition = "TEXT", updatable = false)
  private String gender;

  @Column(name = "Age", nullable = false, updatable = false)
  private int age;

  @Column(
      name = "Email",
      columnDefinition = "TEXT",
      updatable =
          false) // unique = true this is one way when we say unique true it is an uniques constrain
  // add constraint cond email unique like that means
  private String email;
}
