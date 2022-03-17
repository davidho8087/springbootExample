package com.bookstore.bookstore.bookstore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Bookstore {

  @Id
  @SequenceGenerator(
      name = "book_store_sequence",
      sequenceName = "book_store_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "book_store_sequence"
  )
  private Integer id;
  private String name;
  private LocalDate date;
  private String publisher;
  private Integer year;

  public Bookstore() {
  }

  public Bookstore(Integer id, String name, LocalDate date, String publisher, Integer year) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.publisher = publisher;
    this.year = year;
  }

  public Bookstore(String name, LocalDate date, String publisher, Integer year) {
    this.name = name;
    this.date = date;
    this.publisher = publisher;
    this.year = year;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Bookstore{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", date=" + date +
        ", publisher='" + publisher + '\'' +
        ", year=" + year +
        '}';
  }
}
