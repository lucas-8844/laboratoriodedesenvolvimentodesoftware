package model;

import jakarta.persistence.*;

@Entity
public class EmpresaParceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String email;
    private String endereco;

    // Getters e Setters
}