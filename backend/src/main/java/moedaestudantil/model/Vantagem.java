package com.moedaestudantil.model;
@Entity
@Data
public class Vantagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Integer custoEmMoedas;

    @ManyToOne
    private Empresa empresa;
}
