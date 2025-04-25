package com.moedaestudantil.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/empresas")
public class EmpresaParceiraController {

    private List<String> empresas = new ArrayList<>();

    @GetMapping
    public List<String> listar() {
        return empresas;
    }

    @PostMapping
    public void salvar(@RequestBody String nomeEmpresa) {
        empresas.add(nomeEmpresa);
    }
}
