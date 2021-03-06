package br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;
//PADR?O DE PROJETO COMMAND
public class GeraPedidoHandler {

	private List<AcaoAposGerarPedido> acoesAposGerarPedido;

	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoesAposGerarPedido = acoes;
	}

//	PADR?O DE PROJETO FA?ADE
	public void executar(GeraPedido geraPedido) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);
		
		this.acoesAposGerarPedido.forEach(a -> a.executarAcao(pedido));
	}

}
