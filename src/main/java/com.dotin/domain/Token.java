package com.example.demo.domain;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "token")
public class Token {

    public Token() {

    }

    public Token(UUID value) {
        this.value = value;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;

    //ToDo value can be uuid?
    @Column
    private UUID value;

    @Column(name = "issue_date")
//    @CreationTimestamp
    private Long issueDate;

    @Column(name = "expire_date")
    private Long expireDate;

    @Column
    private String username;

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    public Long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Long issueDate) {
        this.issueDate = issueDate;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public UUID getValue() {
        return value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
