package com.bookstore.bookstore;

import com.bookstore.bookstore.Book.Book;
import com.bookstore.bookstore.Student.Student;
import com.bookstore.bookstore.Student.StudentRepository;
import com.bookstore.bookstore.StudentIdCard.StudentIdCard;
import com.bookstore.bookstore.StudentIdCard.StudentIdCardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookstoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }


  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository) {
    return args -> {

      Faker faker = new Faker();

      String fullName = faker.name().fullName();

      // Create Student
      Student student = new Student(
          fullName,
          faker.number().numberBetween(5, 55));

      // Books

      student.addBook(
          new Book("Clean Code", LocalDateTime.now().minusDays(4)));


      student.addBook(
          new Book("Think and Grow Rich", LocalDateTime.now()));


      student.addBook(
          new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));


      StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);


      student.setStudentIdCard(studentIdCard);


      studentRepository.save(student);


//      // Find Student by id
      studentRepository.findById(1L)
          .ifPresent(s -> {
            System.out.println("fetch book lazy...");
            List<Book> books = student.getBooks();
            books.forEach(book -> {
              System.out.println(
                  s.getFullName() + " borrowed " + book.getBookName());
            });
          });

//      studentRepository.findById(1L).ifPresentOrElse(
//          System.out::println,
//          () -> System.out.println("Student not found"));


       //Find Student ID card
//      studentIdCardRepository.findById(1L)
//          .ifPresent(System.out::println);

           // List all student by age group
//      studentRepository.findStudentByAgeGroup(50).forEach(System.out::println);

//       System.out.println("Deleting Maria 1");
     // studentRepository.deleteById(1L);
      //System.out.println(studentRepository.deleteStudentById(1L));

    };
  }

}
