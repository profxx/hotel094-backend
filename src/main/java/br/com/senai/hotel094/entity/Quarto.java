package br.com.senai.hotel094.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Quarto {

    @Id
    private Long numero;
    private String tipo;
    private int capacidade;
    private double preco;
    private String disponibilidade;
    
}
