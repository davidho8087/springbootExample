package com.bookstore.bookstore.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Ctrl B to check JpaRepository Details
@Repository
public interface BookstoreRepository extends JpaRepository<Bookstore, Integer> {

  // @Query("SELECT b FROM Bookstore s WHERE b.publisher = ?david")
  Optional<Bookstore> findBookstoreByPublisher(String publisher);
}
