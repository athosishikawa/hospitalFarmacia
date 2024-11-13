package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer>{

    @Query("SELECT p FROM Farmacia p WHERE p.cnpj = :cnpj")
    public Farmacia findByCnpj(@Param("cnpj") String cnpj);
} 