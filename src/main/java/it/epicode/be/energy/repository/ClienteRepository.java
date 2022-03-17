package it.epicode.be.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.energy.model.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
