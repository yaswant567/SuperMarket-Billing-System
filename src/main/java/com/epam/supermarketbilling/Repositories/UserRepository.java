package com.epam.supermarketbilling.Repositories;

import com.epam.supermarketbilling.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Items, Long> {
}
