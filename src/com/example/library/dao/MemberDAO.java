package com.example.library.dao;

import com.example.library.model.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {
    int save(Member member) throws SQLException;
    Member findById(int id) throws SQLException;
    List<Member> findAll() throws SQLException;

    int update(Member member) throws SQLException;
    int delete(int id) throws SQLException;
}
