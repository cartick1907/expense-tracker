package com.kartik.expenseTracker.entity;

import jakarta.persistence.*;

@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    Long Id;
    Double amount;
    String description;

//    String Expense_Day;
//    Integer Expense_Date;
//
//    String Expense_Month;
//
//    Long Expense_Time;



    public Long getId() {
        return Id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getExpense_Day() {
//        return Expense_Day;
//    }
//
//    public void setExpense_Day(String Expense_Day) {
//        Expense_Day = Expense_Day;
//    }
//
//    public Integer getExpense_Date() {
//        return Expense_Date;
//    }
//
//    public void setExpense_Date(Integer Expense_Date) {
//        Expense_Date = Expense_Date;
//    }
//
//    public String getExpense_Month() {
//        return Expense_Month;
//    }
//
//    public void setExpense_Month(String Expense_Month) {
//        Expense_Month = Expense_Month;
//    }
//
//    public Long getExpense_Time() {
//        return Expense_Time;
//    }
//
//    public void setExpense_Time(Long Expense_Time) {
//        Expense_Time = Expense_Time;
//    }

    public Expenses(Double amount, String description, String Expense_Day, Integer Expense_Date, String Expense_Month, Long Expense_Time) {
        this.amount = amount;
        this.description = description;
//        Expense_Day = Expense_Day;
//        Expense_Date = Expense_Date;
//        Expense_Month = Expense_Month;
//        Expense_Time = Expense_Time;
    }

    public Expenses() {
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
//                ", Expense_Day='" + Expense_Day + '\'' +
//                ", Expense_Date=" + Expense_Date +
//                ", Expense_Month='" + Expense_Month + '\'' +
//                ", Expense_Time=" + Expense_Time +
                '}';
    }
}
