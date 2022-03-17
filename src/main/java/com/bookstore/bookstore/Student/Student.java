package com.bookstore.bookstore.Student;

import com.bookstore.bookstore.StudentIdCard.StudentIdCard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Student")
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  private String fullName;
  private Integer age;


  // JOIN with StudentID Card

  // delete Student will also delete Student ID
  // Virtually mapped with studentIDCard ID
  @OneToOne(
      mappedBy = "student",
      orphanRemoval = true
  )
  private StudentIdCard studentIdCard;


  // Constructors
  public Student() {
  }

  public Student(String fullName, Integer age) {
    this.fullName = fullName;
    this.age = age;
  }

  // GETTER SETTER
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  // String
  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", age=" + age +
        '}';
  }
}
