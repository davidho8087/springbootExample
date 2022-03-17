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


  public void setStudentIdCard(StudentIdCard studentIdCard) {
    this.studentIdCard = studentIdCard;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
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

  public void removeBook(Book book) {
    if (this.books.contains(book)) {
      this.books.remove(book);
      book.setStudent(null);
    }
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
