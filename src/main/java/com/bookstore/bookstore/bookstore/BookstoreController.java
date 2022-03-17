package com.bookstore.bookstore.bookstore;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookstore", produces = "application/json")
public class BookstoreController {

  //Inject Service
  private final BookstoreService bookstoreService;

  // Alt + Enter to add constructor
  BookstoreController(BookstoreService bookstoreService) {
    this.bookstoreService = bookstoreService;
  }

  // Find All
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<Bookstore> getBookStore() {
    // Ref Service
    return bookstoreService.getBookStore();
  }

  // Find One
  @GetMapping("/{bookStoreId}")
  public Bookstore findOne(@PathVariable Integer bookStoreId) {
    return bookstoreService.findOneStore(bookStoreId);
  }

  // Insert
  @PostMapping()
  public Bookstore insertBook(@RequestBody BookstoreCreateDto bookstoreCreateDto) {
    // Alt + enter
    return bookstoreService.insertBook(bookstoreCreateDto);
  }

  @DeleteMapping("/{bookStoreId}")
  public void deleteBookstore(@PathVariable("bookStoreId") Integer bookStoreId) {
    bookstoreService.deleteBookstore(bookStoreId);
  }

  @PutMapping("/{bookStoreId}")
  public Bookstore updateBookstore(@PathVariable Integer bookStoreId, @RequestBody Bookstore bookstore) {
    return bookstoreService.updateBookstore(bookStoreId, bookstore);
  }
}
