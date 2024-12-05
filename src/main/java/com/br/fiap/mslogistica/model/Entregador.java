package com.br.fiap.mslogistica.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table (name="tb_entregador")
public class Entregador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entregador_id")
    private Integer id;

    @Column(name = "entregador_cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "entregador_nome", nullable = false)
    private String nome;

    @Column(name = "entregador_telefone", nullable = false)
    private String telefone;
}
