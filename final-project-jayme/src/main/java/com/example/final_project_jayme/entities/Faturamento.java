package com.example.final_project_jayme.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Faturamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToMany(mappedBy = "faturamento")
    private List<FaturamentoItem> itens;
    public void calcularValorTotal() {
        valorTotal = itens.stream()
                .map(FaturamentoItem::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
