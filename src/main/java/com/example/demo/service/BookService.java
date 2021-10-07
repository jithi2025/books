package com.example.demo.service;

import com.example.demo.dto.BookRequest;
import com.example.demo.exception.CustomException;
import com.example.demo.model.Book;

import java.util.List;
import java.util.Map;


public interface BookService {
    public Book save(BookRequest bookInfo);
    public List<Book> listAll();
    public Book getBookById(int id) throws CustomException;
    public void updateBook(int id , BookRequest bookRequest) throws CustomException;
    public void updateBookByAnyField(int id, Map<String, Object> values) throws CustomException;
    public void deleteBook(int id) throws CustomException;
}
