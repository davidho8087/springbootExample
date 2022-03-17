package com.bookstore.bookstore.bookstore;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookstoreService {

  private final BookstoreRepository bookstoreRepository;

  public BookstoreService(BookstoreRepository bookstoreRepository) {
    this.bookstoreRepository = bookstoreRepository;
  }

  // Get Books
  List<Bookstore> getBookStore() {
    return bookstoreRepository.findAll();
  }

  // Insert Books
  Bookstore insertBook(BookstoreCreateDto bookstoreCreateDto) {
    Optional<Bookstore> bookstoreByEmail = bookstoreRepository.findBookstoreByPublisher(bookstoreCreateDto.getPublisher());

    if (bookstoreByEmail.isPresent()) {
      throw new IllegalStateException("Publisher taken");
    }

    System.out.println((bookstoreCreateDto));
    return bookstoreRepository.save(bookstoreCreateDto);
  }

  // Delete BookStore
  void deleteBookstore(Integer bookstoreId) {
    boolean exists = bookstoreRepository.existsById(bookstoreId);
    if (!exists) {
      throw new IllegalStateException("Bookstore Id does not exist");
    }
    bookstoreRepository.deleteById(bookstoreId);
  }

  // Update BookStore
  Bookstore updateBookstore(Integer bookStoreId, Bookstore bookstore) {
    boolean exists = bookstoreRepository.existsById(bookStoreId);

    if (!exists) {
      throw new IllegalStateException("Bookstore Id does not exist");
    }


    return bookstoreRepository.findById(bookStoreId)
        .map(data -> {
          data.setName(bookstore.getName());
          data.setDate(bookstore.getDate());
          data.setPublisher(bookstore.getPublisher());
          data.setYear(bookstore.getYear());
          return bookstoreRepository.save(data);
        })
        .orElseGet(() -> {
          bookstore.setId(bookStoreId);
          return bookstoreRepository.save(bookstore);
        });
  }

  Bookstore findOneStore(Integer bookStoreId) {
    return bookstoreRepository.findById(bookStoreId)
        .orElseThrow(() -> {
          throw new IllegalStateException("Bookstore Id does not exist");
        });
  }
}
