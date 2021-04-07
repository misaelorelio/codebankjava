package com.bank.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.api.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}

