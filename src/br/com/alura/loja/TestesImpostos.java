package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.imposto.CalculadoraImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesImpostos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		CalculadoraImpostos calculadora = new CalculadoraImpostos();

		System.out.println(calculadora.calcular(orcamento, new ISS(null)));
		System.out.println(calculadora.calcular(orcamento, new ICMS(null)));
		System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
//		System.out.println(calculadora.calcular(orcamento, new ISS()));
	}

}
