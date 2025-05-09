package com.moedaestudantil.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; // DISTRIBUICAO ou RESGATE
    private Integer valor;
    private LocalDateTime data;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Empresa empresa;
}
