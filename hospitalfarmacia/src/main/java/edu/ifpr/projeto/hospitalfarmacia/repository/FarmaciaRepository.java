package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer>{

    
} 