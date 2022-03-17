package it.epicode.be.energy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.epicode.be.energy.model.Comuni;



public interface ComuniRepository extends CrudRepository<Comuni, Long>  {

	Page<Comuni> findById(Pageable pageable);



	

}
