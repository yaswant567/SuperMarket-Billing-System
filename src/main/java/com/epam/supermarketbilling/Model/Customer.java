package com.epam.supermarketbilling.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name="Invoice_Id")
    @GeneratedValue(generator = "item_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "item_seq", sequenceName = "item_sequence", initialValue = 111, allocationSize = 1)
    private Long id;
    @Column(name = "Customer_Name", nullable = false)
    private String name;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Mobile", length = 10, nullable = false)
    private String mobile;
    @Column(name = "Date_Time", length = 10, nullable = false)
    private String dateTime;
    @Column(name = "Amount", nullable = false)
    private int amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
