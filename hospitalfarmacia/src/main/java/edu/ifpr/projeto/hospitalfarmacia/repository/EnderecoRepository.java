package edu.ifpr.projeto.hospitalfarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import edu.ifpr.projeto.hospitalfarmacia.model.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    @Query("SELECT e FROM Endereco e WHERE e.estado = :estado")
    public List<Endereco> findByEstado(@Param("estado") String estado);
}
