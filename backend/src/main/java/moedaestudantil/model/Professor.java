package com.moedaestudantil.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
}
