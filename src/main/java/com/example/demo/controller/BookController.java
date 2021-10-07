package com.example.demo.controller;

import com.example.demo.dto.BookRequest;
import com.example.demo.exception.CustomException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<String> createBook( @Valid  @RequestBody BookRequest bookInfo) {
        bookService.save(bookInfo);
        return new ResponseEntity<>("Successfully created a book", HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public List<Book> getBook(Book book) {
        return bookService.listAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) throws CustomException {
            return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody BookRequest bookInfo) throws CustomException {
        bookService.updateBook(id, bookInfo);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<String> updateBookWithValue(@PathVariable int id, @RequestBody Map<String, Object> values) throws CustomException {
        bookService.updateBookByAnyField(id, values);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) throws CustomException {
        bookService.deleteBook(id);
        return new ResponseEntity<String>("Delete the book successfully", HttpStatus.OK);
    }
}
