package edu.ifpr.projeto.hospitalfarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Pessoa;

@Repository 
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    //<Primeira palavra do nome da interface, tipo do ID>

    @Query("SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
    public Pessoa findByCpf(@Param("cpf") String cpf);

    @Query("SELECT p FROM Pessoa p WHERE p.endereco.id = :idEndereco")
    public List<Pessoa> findByIdEndereco(@Param("idEndereco") int idEndereco);
}
