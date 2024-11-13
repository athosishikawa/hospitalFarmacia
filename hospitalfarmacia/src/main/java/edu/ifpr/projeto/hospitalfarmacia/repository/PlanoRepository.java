package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer>{

    @Query("SELECT p FROM Plano p WHERE p.id = :id")
    public Plano findById(@Param("id") int id);
    
} 
