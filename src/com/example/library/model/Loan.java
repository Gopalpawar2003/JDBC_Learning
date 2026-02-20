package com.example.library.model;

import java.sql.Date;
import java.util.Objects;

public class Loan {
    private int loanId;
    private int bookId;
    private int memberId;
    private Date loneDate;
    private Date returnDate;

    public Loan() {
    }

    public Loan(int loanId, int bookId, int memberId, Date loneDate, Date returnDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.loneDate = loneDate;
        this.returnDate = returnDate;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getLoneDate() {
        return loneDate;
    }

    public void setLoneDate(Date loneDate) {
        this.loneDate = loneDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", loneDate=" + loneDate +
                ", returnDate=" + returnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId == loan.loanId && bookId == loan.bookId && memberId == loan.memberId && Objects.equals(loneDate, loan.loneDate) && Objects.equals(returnDate, loan.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, bookId, memberId, loneDate, returnDate);
    }
}
