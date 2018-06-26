package com.exemple.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CadastrarClienteValido.class, 
	CadastrarClienteAtivo.class, 
	CadastrarClienteComCPFjaCadastrado.class, 
	CadastrarClienteComNumeroCPFcomValorMaximo.class, 
	CadastrarClienteComNumeroCPFcomValorMinimo.class, 
	CadastrarClienteComNumeroCPFmaior11Digitos.class, 
	CadastrarClienteInativo.class, 
	CadastrarClientePreenchendoApenasCampoAtivo.class, 
	CadastrarClientePreenchendoApenasCampoCPF.class, 
	CadastrarClientePreenchendoApenasCampoInativo.class, 
	CadastrarClientePreenchendoApenasCampoNome.class, 
	CadastrarTransacaoComClienteInativo.class, 
	CadastrarTransacaoComValorIgualAoSaldoDisponivel.class, 
	CadastrarTransacaoComValorMaiorQueSaldoDisponivel.class, 
	CadastrarTransacaoComValorMenorQueSaldo.class, 
	CancelarUmCadastro.class, 
	ComportamentoDoBotaoLimparEmFormularioPreenchido.class, 
	ComportamentoDoBotaoLimparEmUmFormularioVazio.class, 
	ComportamentoDoBotaoRemoverCliente.class, 
	ComportamentoDoBotaoSair.class, 
	ComportamentoDoBotaoVisualizarUmCliente.class, 
	ComportamentoLinkEsqueciSenha.class, 
	EditarUmClienteCadastrado.class, 
	ListarTodasAsTransacoes.class, 
	LoginComUsuarioInvalidoeSenhaValida.class, 
	LoginComUsuarioValidoeSenhaInvalida.class, 
	LoginComUsuarioValidoeSenhaValida.class, 
	LoginUsuarioInvalidoSenhaInvalida.class, 
	PesquisarClienteCadastradoPeloNome.class })

public class TodosOsTestes {



}
