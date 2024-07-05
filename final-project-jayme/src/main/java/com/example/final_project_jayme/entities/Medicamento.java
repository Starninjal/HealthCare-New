package com.example.final_project_jayme.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    private String dosagem;

    @ManyToMany
    @JoinTable(
            name = "paciente_medicamento",
            joinColumns = @JoinColumn(name = "medicamento_id"),
            inverseJoinColumns = @JoinColumn(name = "paciente_id"))
    private List<Paciente> pacientes;
}
