package com.bookstore.bookstore.StudentIdCard;


import com.bookstore.bookstore.Student.Student;

import javax.persistence.*;

@Entity(name = "StudentIdCard")
public class StudentIdCard {

  @Id
  @GeneratedValue
  private Long id;

  private String CardNumber;


  // Student ID Live here

  // Cascade here = both save and update include student
  // Live Student ID here
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_id_fk"))
  private Student student;


  // Constructor regenerate if any changes
  public StudentIdCard() {
  }

  public StudentIdCard(String cardNumber, Student student) {
    CardNumber = cardNumber;
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
    return CardNumber;
  }

  public void setCardNumber(String cardNumber) {
    CardNumber = cardNumber;
  }

  // STRING

  @Override
  public String toString() {
    return "StudentIdCard{" +
        "id=" + id +
        ", CardNumber='" + CardNumber + '\'' +
        ", student=" + student +
        '}';
  }
}
