package com.example.simpledemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/book")
public class BookController {

  private BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping(path = "/save")
  public Book saveBook(@RequestBody Book book){
    return bookService.saveBook(book);
  }

  //localhost:8080/book/get/3
  @GetMapping(path = "get/{id}")
  public Book findById(@PathVariable(name = "id") Long id){
    return bookService.getBookById(id);
  }

  @GetMapping(path = "get/all")
  public List<Book> getAllBooks(){
    return bookService.getAllBooks();
  }

  @DeleteMapping(path = "delete/{id}")
  public String deleteBook(@PathVariable(name = "id") Long id){
    return bookService.deleteBook(id);
  }

  @GetMapping(path = "get/author")
  public List<Book> findByAuthor(@RequestParam String author){
    return bookService.getBookByAuthor(author);
  }
}
