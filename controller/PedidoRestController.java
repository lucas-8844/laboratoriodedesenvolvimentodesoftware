@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
    @Autowired
    private PedidoAluguelService pedidoService;

    @PostMapping("/salvar")
    public ResponseEntity<PedidoAluguel> salvarPedido(@RequestBody PedidoAluguel pedido) {
        PedidoAluguel novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PedidoAluguel>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarTodosPedidos());
    }
}
