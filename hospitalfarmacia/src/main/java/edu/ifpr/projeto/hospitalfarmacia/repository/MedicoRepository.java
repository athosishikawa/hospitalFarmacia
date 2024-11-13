package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

    
    @Query("SELECT p FROM Medico p WHERE p.crm = :crm")
    public Medico findByCrm(@Param("crm") String crm);
} 
