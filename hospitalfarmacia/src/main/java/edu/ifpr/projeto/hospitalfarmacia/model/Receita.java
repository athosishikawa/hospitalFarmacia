package edu.ifpr.projeto.hospitalfarmacia.model;

import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "receita_tb")
@Entity

public class Receita implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date data;

    //TODO: criar objetos Medicamento, medico, paciente, etc

    @Column
    private Medicamento medicamento;

    @Column
    private Medico medico;

    @Column
    private Paciente paciente;

    @Column
    private ItemReceita itemReceita;
}
