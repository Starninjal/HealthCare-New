package com.example.final_project_jayme.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String sexo;
    private Date dtNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios;

    @OneToMany(mappedBy = "paciente")
    private List<Contato> contatos;

    @OneToMany(mappedBy = "paciente")
    private List<Procedimento> procedimentos;


    @ManyToMany(mappedBy = "pacientes")
    private List<Medicamento> medicamentos;
    @OneToMany(mappedBy = "paciente")
    private List<Faturamento> faturamentos;
    
}