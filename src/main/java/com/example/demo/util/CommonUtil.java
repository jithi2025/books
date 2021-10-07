package com.example.demo.util;

import com.example.demo.dto.BookRequest;
import com.example.demo.model.Book;

public class CommonUtil {

    public static Book getBookInfo(Book book, BookRequest bookRequest) {
        Book bookObj = book;
        bookObj.setIsbn(bookRequest.getIsbn());
        bookObj.setAuthor(bookRequest.getAuthor());
        bookObj.setDescription(bookRequest.getDescription());
        bookObj.setClassification(bookRequest.getClassification());
        bookObj.setName(bookRequest.getName());
        bookObj.setPrice(bookRequest.getPrice());
        return bookObj;
    }
}
