package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.ItemReceita;

@Repository
public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Integer>{
    
}
