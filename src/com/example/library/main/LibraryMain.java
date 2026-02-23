package com.example.library.main;

import com.example.library.service.BookService;
import com.example.library.service.MemberService;
import com.example.library.util.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class LibraryMain {
        static void main() {

       /* try {
            Connection conn = DbConnection.getConnection();
            if (conn != null){
                System.out.println("Connection established");
            }
            else {
                System.out.println("not Connected");
            }
        } catch (SQLException e) {
            System.out.println("Error Connecting" + e.getMessage());
        }
BookService bookService =  new BookService();
        bookService.displayAllBooks();
        bookService.getBookById();

        */
        MemberService memberService = new MemberService();
        // memberService.addMember();
        memberService.deleteByID();
    }
}


