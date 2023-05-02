package com.epam.supermarketbilling.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Item_name",nullable = false)
    private String name;
    @Column(name = "Quantity", nullable = false)
    private int qty;
    @Column(name = "Price(/unit)",nullable = false)
    private float price;

    public Products() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
}