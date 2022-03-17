package com.bookstore.bookstore.StudentIdCard;


import com.bookstore.bookstore.Student.Student;

import javax.persistence.*;

@Entity(name = "StudentIdCard")
public class StudentIdCard {

  @Id
  @GeneratedValue
  private Long id;
  private String cardNumber;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(
      name = "student_id",
      referencedColumnName = "id",
      foreignKey = @ForeignKey(
          name = "student_id_fk"
      )
  )
  private Student student;

  // Constructor regenerate if any changes
  public StudentIdCard() {
  }

  public StudentIdCard(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public StudentIdCard(String cardNumber, Student student) {
    this.cardNumber = cardNumber;
    this.student = student;
  }

  // GETTER SETTER

  public Long getId() {
    return id;
  }
  public String getCardNumber() {
    return cardNumber;
  }

  // STRING
  @Override
  public String toString() {
    return "StudentIdCard{" +
        "id=" + id +
        ", cardNumber='" + cardNumber + '\'' +
//        ", student=" + student +
        '}';
  }
}
