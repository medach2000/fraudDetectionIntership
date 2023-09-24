package com.proxym.fraudDetection.entities;

import jakarta.persistence.Column;

import java.sql.Date;

public class RegistrationDTO {

    @Column(name = "First Name")
    private String firstName;
    @Column(name = "Middle Name")
    private String MiddleName;
    @Column(name = "Last Name")
    private String lastName;
    @Column(name = "Mobile Number")
    private long mobileNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "Date of Birth")
    private Date dateOfBirth;
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String firstName, String middleName, String lastName, long mobileNumber, String email, Date dateOfBirth, String username, String password) {
        this.firstName = firstName;
        MiddleName = middleName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "firstName='" + firstName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ",username=" + username +
                ", password='" + password + '\'' +
                '}';
    }
}
