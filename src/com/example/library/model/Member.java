package com.example.library.model;

import java.sql.Date;
import java.util.Objects;

public class Member {
    private int memberId;
    private String fullName;
    private String email;
    private String phone;
    private Date joinedDate;

    public Member() {
    }

    public Member(int memberId, String fullName, String email, String phone, Date joinedDate) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.joinedDate = joinedDate;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", joinedDate=" + joinedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId && Objects.equals(fullName, member.fullName) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(joinedDate, member.joinedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, fullName, email, phone, joinedDate);
    }
}
