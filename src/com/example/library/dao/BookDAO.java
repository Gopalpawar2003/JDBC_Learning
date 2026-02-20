package com.example.library.dao;

import com.example.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    // insert
    int saveBook(Book book) throws SQLException;
    // update
    int updateBook(int bookId, double price) throws SQLException;
    // delete

    // selectAll
    List<Book> getAllBooks() throws SQLException;
    // selectByTitle
    // selectByID
    Book getByID (int book_id) throws SQLException;
    // selectByAuthor
}
