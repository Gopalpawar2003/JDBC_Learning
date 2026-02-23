package com.example.library.service;

import com.example.library.dao.MemberDAO;
import com.example.library.dao.MemberDAOImpl;
import com.example.library.model.Member;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberService {
    MemberDAO memberDAO = new MemberDAOImpl();

    public void addMember(){
        // get data from user
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter follwing details to add the member");
        System.out.print("Enter Member Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter Member Email: ");
        String email = scanner.nextLine();

        System.out.println("enter Memeber phone number without 0 or country code");
        String phoneNo = scanner.nextLine();
        scanner.close();

        Member member = new Member();
        member.setFullName(fullName);
        member.setEmail(email);
        member.setEmail(phoneNo);

        try {
           int response = memberDAO.save(member);
           if (response == 1){
               System.out.println("member Added successfully");
           }
        } catch (SQLException e) {
            System.out.println("member not added");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void getMemberByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter member id");
        int id = scanner.nextInt();

        try {
            Member member = memberDAO.findById(id);
            if (member!= null){
                System.out.println(member);
            }else {
                System.out.println("invalid id ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter member id to delete member");

        try {
            int id = scanner.nextInt();
            int rows = memberDAO.delete(id);
            if (rows > 0){
                System.out.println("deleted sucessfully");

            }else {
                System.out.println("not deleted, invalid id");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (InputMismatchException e){
            System.out.println("enter id in integer only");
        }
    }
}
