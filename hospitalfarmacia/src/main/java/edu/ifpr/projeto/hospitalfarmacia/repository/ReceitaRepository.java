package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

    
    @Query("SELECT p FROM Receita p WHERE p.id = :id")
    public Receita findById(@Param("id") int id);
} 
