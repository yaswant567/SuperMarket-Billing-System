package com.epam.supermarketbilling.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Items")
public class Items {
    @Id
    private Long id;
    @Column(name = "S_no")
    @GeneratedValue(generator = "item_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "item_seq", sequenceName = "item_sequence", initialValue = 1, allocationSize = 1)
    private Long sno;
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

    public Long getSno() {
        return sno;
    }
    public void setSno(Long sno)
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