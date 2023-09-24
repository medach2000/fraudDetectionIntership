package com.proxym.fraudDetection.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "First Name")
    private String firstName;

    @Column(name = "Middle Name")
    private String middleName;

    @Column(name = "Last Name")
    private String lastName;



    @Column(name = "Mobile Number")
    private long mobileNumber;

    @Column(name = "Email")
    private String email;


    @Column(name = "Date of Birth")
    private Date dateOfBirth;

    @Column(name="User_Password")
    private String password;

    public User(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @PrimaryKeyJoinColumn(name = "Account")
    @OneToOne
    private Account account;


    public User() {
    }


    public int getUserId() {
        return userId;
    }



    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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


    public void setEmailID(String email) {
        this.email = email;
    }



    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }


    public User(String firstName, String middleName, String lastName, long mobileNumber,
                String email, Date dateOfBirth, Account account) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;

        this.mobileNumber = mobileNumber;
        this.email = email;

        this.dateOfBirth = dateOfBirth;
        this.account = account;
    }
}
