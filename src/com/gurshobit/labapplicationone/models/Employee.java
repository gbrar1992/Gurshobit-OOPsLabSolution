package com.gurshobit.labapplicationone.models;

public class Employee {
    private String firstName = "John";
    private String lastName = "Doe";
    private String email;
    private String password;
    private String departmentName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Dear " + firstName + " your generated credentials are as follows: " + System.lineSeparator() +
                "Email --> " + email + System.lineSeparator() + "Password --> " + password + System.lineSeparator();
    }
}
