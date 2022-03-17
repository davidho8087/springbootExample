package com.bookstore.bookstore.Book;


import com.bookstore.bookstore.Student.Student;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Book")
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue
  private Long id;

  @Column(
      name = "created_at",
      nullable = false,
      columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
  )
  private LocalDateTime createAt;

  private String bookName;


  // MANY books TO ONE student
  @ManyToOne
  @JoinColumn(
      name = "student_id",
      nullable = false,
      referencedColumnName = "id",
      foreignKey = @ForeignKey(
          name = "student_book_fk"
      )
  )
  private Student student;

  //------------------------------------

  // Constructors
  public Book() {
  }

  public Book( String bookName, LocalDateTime createAt) {
    this.createAt = createAt;
    this.bookName = bookName;
  }

  // Getter Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreateAt() {
    return createAt;
  }

  public void setCreateAt(LocalDateTime createAt) {
    this.createAt = createAt;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", bookName='" + bookName + '\'' +
        ", student=" + student +
        '}';
  }
}
