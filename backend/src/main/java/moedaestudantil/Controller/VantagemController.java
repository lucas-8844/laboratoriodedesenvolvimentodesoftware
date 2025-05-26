@RestController
@RequestMapping("/vantagens")
public class VantagemController {
    @Autowired
    private VantagemService vantagemService;

    @PostMapping
    public Vantagem cadastrar(@RequestBody Vantagem vantagem) {
        return vantagemService.cadastrar(vantagem);
    }

    @GetMapping
    public List<Vantagem> listar() {
        return vantagemService.listar();
    }

    @GetMapping("/empresa/{empresaId}")
    public List<Vantagem> listarPorEmpresa(@PathVariable Long empresaId) {
        return vantagemService.listarPorEmpresa(empresaId);
    }
}
