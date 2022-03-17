package com.bookstore.bookstore.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

  // Custom query
  @Query("SELECT s FROM Student s WHERE s.fullName = ?1")
  Optional<Student> findStudentByFullName(String name);

  // Listing
  @Query("SELECT s FROM Student s WHERE s.age >= ?1")
  List<Student> findStudentByAgeGroup(Integer age);

  @Transactional
  @Modifying
  @Query("DELETE FROM Student u WHERE u.id = ?1")
  int deleteStudentById(Long id);

}
