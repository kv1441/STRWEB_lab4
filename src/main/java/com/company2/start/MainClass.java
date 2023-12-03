package com.company2.start;

import com.company2.action.StudentAction;
import com.company2.model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

    StudentAction action = new StudentAction();

    public static void main(String[] args) {

        MainClass mainclass = new MainClass();
        int value;

        do {

            System.out.println("valid operations are");

            System.out.println("EXIT(0), ADD(1), UPDATE(2), DELETE(3), FETCHBYID(4), FETCHBYPHONENUMBER(5), FETCHBYFIRSTNAME(6), FETCHALL(7)");
            System.out.println("Enter valid operation number 0-7");

            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            try {

                switch (value) {
                    case 1:
                        mainclass.addStudent();
                        break;
                    case 2:
                        mainclass.updateStudent();
                        break;
                    case 3:
                        mainclass.deleteStudent();
                        break;
                    case 4:
                        mainclass.fetchStudentById();
                        break;
                    case 5:
                        mainclass.fetchStudentByPhoneNumber();
                        break;
                    case 6:
                        mainclass.searchStudentByFirstName();
                        break;
                    case 7:
                        mainclass.fetchAllStudent();
                        break;
                    case 0:
                        System.out.println("Exiting code");
                        break;
                    default:
                        System.out.println("Not a valid entry");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (value != 0);

    }


    public void addStudent() throws SQLException {

        Student student = new Student();
        Scanner insert = new Scanner(System.in);

        System.out.println("Enter First Name");
        student.setFirstName(insert.next());

        System.out.println("Enter Last Name");
        student.setLastName(insert.next());

        System.out.println("Enter phone number");
        student.setPhoneNumber(insert.next());

        action.insert(student);

    }

    public void updateStudent() throws SQLException {

        Student student = new Student();
        Scanner insert = new Scanner(System.in);

        System.out.println("Enter Student Id");
        student.setId(insert.nextLong());

        System.out.println("Enter First Name");
        student.setFirstName(insert.next());

        System.out.println("Enter Last Name");
        student.setLastName(insert.next());

        System.out.println("Enter phone number");
        student.setPhoneNumber(insert.next());

        action.update(student);

    }

    public void deleteStudent() throws SQLException {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        action.delete(id);
    }

    public void fetchStudentById() throws SQLException {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        action.fetchById(id);
    }

    public void fetchStudentByPhoneNumber() throws SQLException {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mobile Number");
        String mobileNo = insert.next();
        action.fetchByPhoneNumber(mobileNo);
    }

    public void searchStudentByFirstName() throws SQLException {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String name = insert.next();
        action.searchByFirstName(name);
    }

    public void fetchAllStudent() throws SQLException {
        action.fetchAll();
    }

}