package com.example.demo.util;

import java.util.Date;

public class ErrosApi {
	
	private Long idConta;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Date dataCadastro;
	
	public ErrosApi(String nome, String cpf, Date dataNascimento, Date dataCadastro ) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		
	}

}
