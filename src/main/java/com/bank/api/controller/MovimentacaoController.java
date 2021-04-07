package com.bank.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bank.api.model.Movimentacao;
import com.bank.api.repository.MovimentacaoRepository;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@GetMapping("/lista")
	public List<Movimentacao> listar() {
		return movimentacaoRepository.findAll();
	}

	@PostMapping("/adicionar")
	public Movimentacao adicionar(@Valid @RequestBody Movimentacao movimentacao) {

		return movimentacaoRepository.save(movimentacao);
	}

	@GetMapping("/saldo/{id}")
	public Double buscarSaldo(@PathVariable("id") String id) {
		return movimentacaoRepository.buscarSaldo(id);
	}

	@GetMapping("/extrato/{id}")
	public List<Movimentacao> consultarExtrato(@PathVariable("id") Long id) {
		List<Movimentacao> listaMovimentacao = movimentacaoRepository.consultarExtrato(id);

		Double saldo = 0.;
		for (Integer x = 0; x < listaMovimentacao.size(); x++) {
			if (listaMovimentacao.get(x).getTipoTransacao() == 1) {
				saldo += listaMovimentacao.get(x).getValorTransacao();
			} else {
				saldo -= listaMovimentacao.get(x).getValorTransacao();
			}
			listaMovimentacao.get(x).setSaldo(saldo);
		}
		return listaMovimentacao;
	}

}
