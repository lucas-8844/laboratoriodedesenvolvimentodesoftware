package com.moedaestudantil.service;
@Service
public class VantagemService {
    @Autowired
    private VantagemRepository vantagemRepository;

    public Vantagem cadastrar(Vantagem vantagem) {
        return vantagemRepository.save(vantagem);
    }

    public List<Vantagem> listar() {
        return vantagemRepository.findAll();
    }

    public List<Vantagem> listarPorEmpresa(Long empresaId) {
        return vantagemRepository.findByEmpresaId(empresaId);
    }
}
