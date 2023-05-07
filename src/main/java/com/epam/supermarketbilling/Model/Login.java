package com.epam.supermarketbilling.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class Login
{
    @Id
    @Column(name = "emp_id", nullable = false)
    @GeneratedValue(generator = "emp_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "emp_seq", sequenceName = "emp_sequence", initialValue = 1190, allocationSize = 1)
    private Long id;
    @Column(name = "emp_name", nullable = false)
    private String name;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name = "roles", nullable = false)
    private String role;

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
