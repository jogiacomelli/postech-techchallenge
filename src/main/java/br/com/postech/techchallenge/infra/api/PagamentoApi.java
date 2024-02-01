package br.com.postech.techchallenge.infra.api;
import br.com.postech.techchallenge.core.domain.entity.enums.StatusPagamento;
import br.com.postech.techchallenge.core.repository.PedidoRepository;
import br.com.postech.techchallenge.infra.controller.PagamentoController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/techchallenge/pagamento")
public class PagamentoApi {

    private final PagamentoController pagamentoController;

    public PagamentoApi(PedidoRepository pedidoRepository) {
        this.pagamentoController = new PagamentoController(pedidoRepository);
    }

    @PostMapping
    public void pagar(@RequestParam Long idPedido, @RequestParam StatusPagamento statusPagamento) {
        pagamentoController.updatePagamento(1L, null);
    }

}
