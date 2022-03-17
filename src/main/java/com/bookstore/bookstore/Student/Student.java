package com.bookstore.bookstore.Student;

import com.bookstore.bookstore.Book.Book;
import com.bookstore.bookstore.StudentIdCard.StudentIdCard;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  private String fullName;
  private Integer age;


  // ONE TO ONE WITH STUDENT CARD
  @OneToOne(
      mappedBy = "student",
      orphanRemoval = true,
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

  )
  private StudentIdCard studentIdCard;


  // ONE TO MANY WITH BOOK
  @OneToMany(
      mappedBy = "student",
      orphanRemoval = true,
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      fetch = FetchType.LAZY
  )
  private List<Book> books = new ArrayList<>();


  // Constructors
  public Student() {
  }

  public Student(String fullName, Integer age) {
    this.fullName = fullName;
    this.age = age;
  }

  // GETTER SETTER


  public String getFullName() {
    return fullName;
  }

  public void setStudentIdCard(StudentIdCard studentIdCard) {
    this.studentIdCard = studentIdCard;
  }


  public List<Book> getBooks() {
    return books;
  }


  // Custom
  public void addBook(Book book) {
    if (!this.books.contains(book)) {
      this.books.add(book);
      book.setStudent(this);
    }
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", age=" + age +
        '}';
  }
}
