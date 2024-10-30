package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Farmaceutico;

@Repository
public interface FarmaceuticoRepository extends JpaRepository<Farmaceutico, Integer>{
    
}
