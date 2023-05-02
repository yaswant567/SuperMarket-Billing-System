package com.epam.supermarketbilling.Repositories;

import com.epam.supermarketbilling.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Products, Long> {
}
