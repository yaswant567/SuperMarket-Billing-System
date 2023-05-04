package com.epam.supermarketbilling.Repositories;

import com.epam.supermarketbilling.Model.CustomerProducts;
import com.epam.supermarketbilling.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CustomerProducts, Long> {
}
