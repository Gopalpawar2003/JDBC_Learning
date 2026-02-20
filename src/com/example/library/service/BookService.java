package com.example.library.service;

import com.example.library.dao.BookDAO;
import com.example.library.main.BookDAOImpl;
import com.example.library.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookService {
    BookDAO bookDAO = new BookDAOImpl();
    Scanner scanner = new Scanner(System.in);
    public void displayAllBooks() {

        try {
            List<Book> allBooks = bookDAO.getAllBooks();

            allBooks.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void getBookById(){
        System.out.println("Enter Id to find Book");
        int bookId = scanner.nextInt();
        try {
            Book bookById = bookDAO.getByID(bookId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void printBooks(Book ...books){
        System.out.format("Id\t Title\t\t Author\t\t Year\t Price\t ISBN\t\t Genere ");
        for (Book book : books) {
            System.out.println(book.getBookId() +"\t");
            System.out.println(book.getTitle() +"\t");
            System.out.println(book.getAuthor() +"\t");
            System.out.println(book.getPublicationYear() +"\t");
            System.out.println(book.getPrice() +"\t");
            System.out.println(book.getIsbn() +"\t");
            System.out.println(book.getGenre() +"\t");

        }
    }
}
