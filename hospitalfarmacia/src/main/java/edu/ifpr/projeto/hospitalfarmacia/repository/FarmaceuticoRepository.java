package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Farmaceutico;

@Repository
public interface FarmaceuticoRepository extends JpaRepository<Farmaceutico, Integer>{
    @Query("SELECT p FROM Farmaceutico p WHERE p.crf = :crf")
    public Farmaceutico findByCrf(@Param("crf") String crf);
}
