package com.sunbeam.beans;

import java.sql.Date;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class Registeration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dob;
    private int status;
    private String role;
    private int result;

    // Getters and setters
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Parameterized constructor
    public Registeration(String firstName, String lastName, String email, String password, String dob, int status, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.status = status;
        this.role = role;
    }

    // Parameterless constructor
    public Registeration() {
    }

    // Method to register a user
    public int registerUser() throws Exception {
        Date dateOfBirth = Date.valueOf(dob);
        User user = new User(0, firstName, lastName, email, password, dateOfBirth, status, role);
        UserDao userDao = new UserDaoImpl();
        int count = 0;
        try {
            count = userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
   
}
