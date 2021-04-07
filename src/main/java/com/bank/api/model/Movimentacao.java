package com.bank.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idMovimentacao;

	@NotNull(message = "O campo valor da transação é obrigatório")
	@Column(nullable = false)
	private Double valorTransacao;

	@NotNull(message = "O campo tipo de transação é obrigatório")
	@Column(nullable = false)
	@Min(value = 1, message = "Informar numero 1 para depósito e 2 para saque")
	@Max(value = 2, message = "Informar numero 2 para saque e 1 para depósito")
	private Integer tipoTransacao;

	@NotNull(message = "O campo data da transação é obrigatório")
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataTransacao;

	@Transient
	private Double saldo;

	@ManyToOne
	private Conta conta;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Long getIdMovimentacao() {
		return idMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setIdMovimentacao(Long idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public Double getValorTransacao() {
		return valorTransacao;
	}

	public Integer getTipoTransacao() {
		return tipoTransacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataTransacao == null) ? 0 : dataTransacao.hashCode());
		result = prime * result + ((idMovimentacao == null) ? 0 : idMovimentacao.hashCode());
		result = prime * result + ((tipoTransacao == null) ? 0 : tipoTransacao.hashCode());
		result = prime * result + ((valorTransacao == null) ? 0 : valorTransacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		if (dataTransacao == null) {
			if (other.dataTransacao != null)
				return false;
		} else if (!dataTransacao.equals(other.dataTransacao))
			return false;
		if (idMovimentacao == null) {
			if (other.idMovimentacao != null)
				return false;
		} else if (!idMovimentacao.equals(other.idMovimentacao))
			return false;
		if (tipoTransacao == null) {
			if (other.tipoTransacao != null)
				return false;
		} else if (!tipoTransacao.equals(other.tipoTransacao))
			return false;
		if (valorTransacao == null) {
			if (other.valorTransacao != null)
				return false;
		} else if (!valorTransacao.equals(other.valorTransacao))
			return false;
		return true;
	}

	public void setTipoTransacao(Integer tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

}
