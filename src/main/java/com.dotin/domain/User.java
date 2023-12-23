package com.example.demo.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String username;
    private String password;
    private Long birthDate;
    private int nationalCode;
    private String firstName;
    private String lastName;
    private String authority;
    private UUID token;

//    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user", cascade = CascadeType.ALL)
//    private Authority authority;
//
//    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user" ,cascade = CascadeType.ALL)
//    private Token token;

    public User() {
    }

    public User(String username, String password, Long birthDate, int nationalCode, String firstName, String lastName,String authority,UUID token) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authority=authority;
        this.token=token;
    }


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    @Column
    public String getUsername() {
        return username;
    }

    @Column
    public String getPassword() {
        return password;
    }

    @Column(name = "birth_date")
    public Long getBirthDate() {
        return birthDate;
    }

    @Column(name = "national_code")
    public int getNationalCode() {
        return nationalCode;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}