package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{

    
    @Query("SELECT p FROM Medicamento p WHERE p.id = :id")
    public Medicamento findById(@Param("id") int id);
} 
