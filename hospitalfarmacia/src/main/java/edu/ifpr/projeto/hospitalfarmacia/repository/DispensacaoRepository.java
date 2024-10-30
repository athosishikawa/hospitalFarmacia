package edu.ifpr.projeto.hospitalfarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.ifpr.projeto.hospitalfarmacia.model.Dispensacao;

public interface DispensacaoRepository extends JpaRepository<Dispensacao, Integer>{
    @Query("SELECT p FROM Dispensacao p WHERE p.id = :id")
    public Dispensacao findById(@Param("id") String id);

    //TODO: verificar 
    @Query("SELECT p FROM Dispensacao p WHERE p.dataDispensacao.id = :iddataDispensacao")
    public List<Dispensacao> findByDatDispensacaos(@Param("dataDispensacao") int dataDispensacao);
}
