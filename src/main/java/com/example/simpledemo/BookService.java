package com.example.simpledemo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    Optional<Book> bookOptional = bookRepository.findById(id);
    return bookOptional.orElse(null);
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public String deleteBook(Long id) {
    bookRepository.deleteById(id);
    return "Book deleted by id: " + id;
  }

  public List<Book> getBookByAuthor(String author) {
    return bookRepository.findAllByAuthor(author);
  }
}
