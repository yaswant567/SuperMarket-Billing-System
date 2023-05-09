package com.epam.supermarketbilling.Model;

import jakarta.persistence.*;
//import javax.validation.constraints.Email;
import org.intellij.lang.annotations.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Login")
public class Login
{
    @Id
    @Column(name = "emp_id", nullable = false)
    @GeneratedValue(generator = "emp_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "emp_seq", sequenceName = "emp_sequence", initialValue = 1190, allocationSize = 1)
    private Long id;
    @Column(name = "emp_name", nullable = false, length = 50)
    private String name;
    @Column(name="password", nullable = false)
//    @Size(min = 8)
    private String password;

    @Column(name="email", nullable = true)
//    @Email
    private String email;

    @Column(name="mobile", nullable = false)
//    @Pattern(regexp = "\\d{10}")
    private String mobile;

//    @Column(name="DOB", nullable = false)
//    @DateTimeFormat(pattern= "dd/MM/yyyy")
////    @Temporal(TemporalType.DATE)
//    private Date date;

    @Column(name="salary", nullable = false)
    private BigDecimal salary;
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

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
