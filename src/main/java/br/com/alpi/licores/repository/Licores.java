package br.com.alpi.licores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alpi.licores.model.Licor;

public interface Licores extends JpaRepository<Licor, Long>{

}
