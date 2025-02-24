package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer>{
    @Query("SELECT p FROM Dependente p WHERE p.id = :id")
    public Dependente findById(@Param("id") int id);

}
