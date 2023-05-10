package com.example.httpaccount_billproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String name;
    private String email;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bill> bills;

    public Account(String name, String email, List<Bill> bills) {
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public Account(){}
}
