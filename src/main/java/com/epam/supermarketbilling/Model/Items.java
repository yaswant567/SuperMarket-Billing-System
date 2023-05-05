package com.epam.supermarketbilling.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Items")
public class Items {
    private Long id;
    @Id
    @Column(name = "S_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    @Column(name = "Item_name",nullable = false)
    private String name;
    @Column(name = "Qty", nullable = false)
    private int qty;
    @Column(name = "Unit_Price",nullable = false)
    private float Price;
    @Column(name = "Total_Price",nullable = false)
    private float totalPrice;


    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public int getSno() {
        return sno;
    }
    public void setSno(int sno)
    {
        this.sno = sno;
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
        return Price;
    }

    public void setPrice(float Price)
    {
        this.Price = Price;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }
}