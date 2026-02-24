package com.example.library.dao;

import com.example.library.model.Member;
import com.example.library.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
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
    public List<Member> findAll() throws SQLException {
        List<Member> memberList = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String selectSql = "SELECT * FROM members";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int memberId = resultSet.getInt("member_id");
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            String phoneNo = resultSet.getString("phone");
            Date joined_date = resultSet.getDate("joined_date");
            Member member = new Member(memberId, fullName, email, phoneNo, joined_date);
            memberList.add(member);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return memberList;
    }

    @Override
    public int update(Member member) throws SQLException {
        Connection connection = DbConnection.getConnection();
        String sql = "UPDATE members SET email= ?, phone = ? WHERE memner_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, member.getEmail());
        preparedStatement.setString(2, member.getPhone());
        preparedStatement.setInt(3, member.getMemberId());

        int rows = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();;
        return rows;
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
