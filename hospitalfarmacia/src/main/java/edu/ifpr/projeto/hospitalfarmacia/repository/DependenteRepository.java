package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifpr.projeto.hospitalfarmacia.model.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Integer>{
    
}
