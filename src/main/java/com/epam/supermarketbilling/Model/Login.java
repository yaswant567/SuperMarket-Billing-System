package com.epam.supermarketbilling.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class Login
{
    @Id
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name")
    private String name;
    private String password;
    @Column(name = "roles")
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
