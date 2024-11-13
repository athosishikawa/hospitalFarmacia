package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.ItemReceita;

@Repository
public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Integer>{
    @Query("SELECT p FROM ItemReceita p WHERE p.id = :id")
    public ItemReceita findById(@Param("id") int id);
}
