package edu.ifpr.projeto.hospitalfarmacia.model;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa_tb") //serve para informar que a classe sera uma tabela no banco 
@Entity
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column 
    private String cpf;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_endereco", nullable = true)
    private Endereco endereco;


}
