package com.epam.supermarketbilling.Repositories;

import com.epam.supermarketbilling.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
}
