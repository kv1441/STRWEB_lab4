package com.company2.model;

import lombok.Data;

@Data
public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{"+"\n" + "id=" + id + "," + "\nfirstName=" + firstName + "," + "\nlastName=" + lastName + "," + "\nphoneNumber=" + phoneNumber + "}\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
