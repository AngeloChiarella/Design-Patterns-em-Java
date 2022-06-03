package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoBancoDados;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Angelo";
		BigDecimal valorOrcamento = new BigDecimal("300");
		Integer quantidadeItens = Integer.parseInt("2");
		
		GeraPedido gerador= new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(
				Arrays.asList(
						new SalvarPedidoBancoDados(), 
						new EnviarEmailPedido(), 
						new LogDePedido()
						));
		handler.executar(gerador);
	}

}
