package com.kartik.expenseTracker.entity;

import jakarta.persistence.*;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long Id;
    String Name;
    Double Balance;

    @OneToOne(cascade = CascadeType.ALL)
    private Expenses expenselist;

    public Expenses getExpenselist() {
        return expenselist;
    }

//    public void setExpenselist(Expenses expenselist) {
//        this.expenselist = expenselist;
//    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public Person(Long id, String name, Double balance, Expenses expenselist) {
        Id = id;
        Name = name;
        Balance = balance;
//        this.expenselist = expenselist;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Balance=" + Balance +
//                ", expenselist=" + expenselist +
                '}';
    }
}
