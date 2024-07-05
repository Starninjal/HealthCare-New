package com.example.final_project_jayme.entities;

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
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}