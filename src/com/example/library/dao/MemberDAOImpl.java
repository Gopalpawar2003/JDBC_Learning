package com.example.library.dao;

import com.example.library.model.Member;
import com.example.library.util.DbConnection;

import java.sql.*;
import java.util.List;

public class MemberDAOImpl implements MemberDAO{

    @Override
    public int save(Member member) throws SQLException {
        Connection conn = DbConnection.getConnection();
        String sql = "INSERT INTO members (full_name, email, phone) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,member.getFullName());
        pstmt.setString(2, member.getEmail());
        pstmt.setString(3, member.getPhone());
        int rows = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return rows;
    }

    @Override
    public Member findById(int id) throws SQLException {
        String sql = "SELECT * FROM member WHERE member_id = ?";
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Member member = null;
        while (resultSet.next()){
            int member_id = resultSet.getInt(1);
            String fullName = resultSet.getString(2);
            String email = resultSet.getString(3);
            String phoneNo = resultSet.getString(4);
            Date date = resultSet.getDate(5);
            member = new Member(member_id, fullName, email, phoneNo, date);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return member;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public int delete(int id) throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "DELETE FROM MEMBERS where member_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        int rows = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return rows;

    }
}
