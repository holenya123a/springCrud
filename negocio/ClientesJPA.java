package com.example.demo.negocio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesJPA extends JpaRepository<Clientes1, Long> {
	
}
