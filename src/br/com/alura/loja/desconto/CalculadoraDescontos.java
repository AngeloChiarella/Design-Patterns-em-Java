package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDescontos {

//	Um Desconto chama o outro - encadeamento
	public BigDecimal calcular(Orcamento orcamento) {
		Desconto desconto = new DescontoMaisCincoItens(
				new DescontoMaiorQuinhentosReais(
						new SemDesconto()));
		return desconto.calcular(orcamento);
	}
}
