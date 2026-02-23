package com.example.library.dao;

import com.example.library.model.Loan;

import java.util.List;

public interface LoanDAO {
    int issueBook(Loan loan);
    int returnBook(int loanId);
    List<Loan> findAll();
}