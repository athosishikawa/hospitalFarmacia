package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

    
    @Query("SELECT p FROM Paciente p WHERE p.id = :id")
    public Paciente findById(@Param("id") int id);
} 
