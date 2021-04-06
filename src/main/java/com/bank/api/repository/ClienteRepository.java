package com.bank.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.api.conta.Conta;

@Repository
public interface ClienteRepository extends JpaRepository<Conta, Long> {
	

}
