package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "Authorities")
public class Authority {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column
    private String authority;




    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
