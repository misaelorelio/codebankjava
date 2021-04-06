package com.bank.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.conta.Conta;
import com.bank.api.repository.ClienteRepository;

@RestController
@RequestMapping("/contas")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Conta> listar() {
	return clienteRepository.findAll();
	}
	
	@PostMapping
	public Conta adicionar(@Valid @RequestBody Conta conta) {
		return clienteRepository.save(conta);
	}

}
