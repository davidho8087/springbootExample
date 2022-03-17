package com.bookstore.bookstore;

import com.bookstore.bookstore.Student.Student;
import com.bookstore.bookstore.Student.StudentRepository;
import com.bookstore.bookstore.StudentIdCard.StudentIdCard;
import com.bookstore.bookstore.StudentIdCard.StudentIdCardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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


      // Create StudentID Card
      StudentIdCard studentIdCard = new StudentIdCard(
          "123456789",
          student);

      studentIdCardRepository.save(studentIdCard);


      // Find Student by id
      studentRepository.findById(2L).ifPresentOrElse(
          System.out::println,
          () -> System.out.println("Student not found"));


      // Find Student ID card
      studentIdCardRepository.findById(1L)
          .ifPresent(System.out::println);

      // Find student by name
      studentRepository.findStudentByFullName("John").ifPresentOrElse(
          System.out::println,
          () -> System.out.println("Student name not found"));

      // List all student by age group
      studentRepository.findStudentByAgeGroup(50).forEach(System.out::println);

//      System.out.println("Deleting Maria 1");
//      System.out.println(studentRepository.deleteStudentById(3L));

    };
  }

}
