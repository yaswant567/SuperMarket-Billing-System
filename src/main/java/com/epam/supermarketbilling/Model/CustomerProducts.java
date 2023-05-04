package com.epam.supermarketbilling.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "CProducts")
public class CustomerProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Item_name",nullable = false)
    private String name;
    @Column(name = "Quantity", nullable = false)
    private int qty;
    @Column(name = "Price(/unit)",nullable = false)
    private float totalPrice;

    public CustomerProducts() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty)
    {
        this.qty = qty;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }
}