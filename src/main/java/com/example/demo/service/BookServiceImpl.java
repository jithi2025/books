package com.example.demo.service;

import com.example.demo.dto.BookRequest;
import com.example.demo.exception.CustomException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(BookRequest bookRequest) {
        return bookRepository.save(CommonUtil.getBookInfo(new Book(), bookRequest));
    }

    @Override
    public List<Book> listAll() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);
        return bookList;
    }

    @Override
    public Book getBookById(int id) throws CustomException {
        try {
            return bookRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new CustomException("No books found with the given id");
        }

    }

    @Override
    public void updateBook(int id, BookRequest bookRequest) throws CustomException {
        try {
            Book bookObj = bookRepository.findById(id).get();
            bookRepository.save(CommonUtil.getBookInfo(bookObj, bookRequest));
        } catch (NoSuchElementException ex) {
            throw new CustomException("Unable to find book with the given id ");
        }
    }

    @Override
    public void updateBookByAnyField(int id, Map<String, Object> values) throws CustomException {
        try {
            Book bookObj = bookRepository.findById(id).get();
            values.forEach((k, v) -> {
                switch (k) {
                    case "name":
                        bookObj.setName((String) v);
                        break;
                    case "description":
                        bookObj.setDescription((String) v);
                        break;
                    case "author":
                        bookObj.setAuthor((String) v);
                        break;
                    case "price":
                        bookObj.setPrice((Double) v);
                        break;
                    case "isbn":
                        bookObj.setIsbn((String) v);
                        break;
                    case "classification":
                        bookObj.setClassification((String) v);
                        break;
                }

            });
             bookRepository.save(bookObj);
        } catch (NoSuchElementException ex) {
            throw new CustomException("Unable to find book with the given id ");
        }
    }

    @Override
    public void deleteBook(int id) throws CustomException {
        try {
            bookRepository.deleteById(id);
        } catch (NoSuchElementException ex) {
            throw new CustomException("Unable to find book with the given id ");
        }
    }
}
