package com.bookstore.bookstore.StudentIdCard;


import com.bookstore.bookstore.Student.Student;

import javax.persistence.*;

@Entity(name = "StudentIdCard")
public class StudentIdCard {

  @Id
  @Column(name = "student_id")
  private Long id;

  private String cardNumber;


  // Student ID Live here

  // Cascade here = both save and update include student
  // Live Student ID here
//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_id_fk"))
//  private Student student;


  @OneToOne
  @MapsId
  @JoinColumn(name = "student_id")
  private Student student;


  // Constructor regenerate if any changes
  public StudentIdCard() {
  }

  public StudentIdCard(String cardNumber, Student student) {
    this.cardNumber = cardNumber;
    this.student = student;
  }

  // GETTER SETTER

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  // STRING


  @Override
  public String toString() {
    return "StudentIdCard{" +
        "id=" + id +
        ", cardNumber='" + cardNumber + '\'' +
        '}';
  }
}
