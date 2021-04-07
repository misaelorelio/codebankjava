package com.bank.api.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity  adicionar(@Valid @RequestBody Conta conta) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataNascimento = conta.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
		int idade = Period.between(dataNascimento, dataAtual).getYears();
		
		if(idade >= 18 ) {
			return ResponseEntity.status(HttpStatus.OK).body(ContaRepository.save(conta));  
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{message: 'Não é possível incluir uma conta bancária para clientes de menor idade'}"); 
		}
		
		
		
	}
	

}
