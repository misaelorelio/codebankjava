package com.bank.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.model.Conta;
import com.bank.api.repository.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaRepository ContaRepository;

	@GetMapping("/listar")
	public List<Conta> listar() {
		return ContaRepository.findAll();
	}

	@PostMapping("/adicionar")
	public Conta adicionar(@Valid @RequestBody Conta conta) {
		return ContaRepository.save(conta);
	}

}
