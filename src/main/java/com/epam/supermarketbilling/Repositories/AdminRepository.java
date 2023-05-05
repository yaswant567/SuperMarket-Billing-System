package com.epam.supermarketbilling.Repositories;

import com.epam.supermarketbilling.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Products, Long> {
}
