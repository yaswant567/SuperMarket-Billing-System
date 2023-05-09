package com.epam.supermarketbilling.Repositories;

import com.epam.supermarketbilling.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Items, Long> {
    @Query("SELECT COALESCE(SUM(totalPrice), 0) FROM Items")
    public long getSumOfColumn();
}
