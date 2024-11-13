package edu.ifpr.projeto.hospitalfarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifpr.projeto.hospitalfarmacia.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer>{

    @Query("SELECT p FROM Log p WHERE p.id = :id")
    public Log findById(@Param("id") int id);
    
} 
