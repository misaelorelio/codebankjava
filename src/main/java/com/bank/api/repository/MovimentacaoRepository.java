package com.bank.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.api.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

	@Query(value = "SELECT ((SELECT IFNULL(sum(movimentacao.valor_transacao),0) from movimentacao WHERE movimentacao.conta_id_conta=conta.id_conta AND movimentacao.tipo_transacao=1) - (SELECT IFNULL(sum(movimentacao.valor_transacao),0) from movimentacao WHERE movimentacao.conta_id_conta=conta.id_conta AND movimentacao.tipo_transacao=2)) as saldo FROM conta WHERE conta.id_conta=?1", nativeQuery = true)
	Double buscarSaldo(String idConta);

	@Query("FROM Movimentacao WHERE conta.idConta=?1 ORDER BY dataTransacao asc")
	List<Movimentacao> consultarExtrato(Long idConta);
}
